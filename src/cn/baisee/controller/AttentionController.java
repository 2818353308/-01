package cn.baisee.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.entity.Attention;
import cn.baisee.entity.Paper;
import cn.baisee.entity.User;
import cn.baisee.service.IAttentionService;
import cn.baisee.vo.PageVo;

/**
 * 关注controller
 * 
 * @author Administrator
 *
 */
@Controller
public class AttentionController {
	// 关注
	@Resource(name = "attentionServiceImpl")
	private IAttentionService attentionService;

	/**
	 * 点击关注
	 */
	@RequestMapping("user/addAttention")
	public String addAttention(String by_user_id, HttpServletRequest request) {
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		System.out.println("被关注人id==" + by_user_id);
		Attention attention = new Attention();
		// 被关注人的ID
		attention.setBy_user_id(Integer.valueOf(by_user_id));
		// 关注人ID
		attention.setUser_id(loginUser.getId());
		attentionService.add_Attention(attention);
		return "redirect:/xianshi.htmlx";
	}

	/**
	 * 查询关注状态
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("query_attention")
	public String query_attention(ModelMap map, HttpServletRequest request) {
		PageVo vo = (PageVo) request.getAttribute("paper");
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		List<Attention> attention_state = null;
		if (loginUser != null) {
			// 将查询出关注的用户id放到attention_state
			attention_state = attentionService.query_guanzhu(loginUser.getId());
		}
		// 循环出所查询出的帖子
		if (attention_state != null) {
			for (Paper p : vo.getResult()) {
				// 判断这个帖子的发帖人id与登录人id是否一致 一致则设为已关注
				for (Attention a : attention_state) {
					if (a.getBy_user_id() == Integer.valueOf(p.getUser_id())) {
						System.out.println(loginUser.getUname() + "关注了" + a);
						p.setAttention_state(1);
						p.setAttention_id(a.getAttention_id());
					}
				}
			}
		}
		// 跳转到FabulousController
		return "forward:queryut.htmlx";
	}
	
	/**
	 * 点击取消关注
	 */
	@RequestMapping("user/delete_attention")
	public String delete_attention(String attention_id){
		System.out.println("取消关注的ID="+attention_id);
		attentionService.deleteAttention(Integer.valueOf(attention_id));
		return "redirect:/xianshi.htmlx";
	}
	
	

}
