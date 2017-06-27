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
 * ��עcontroller
 * 
 * @author Administrator
 *
 */
@Controller
public class AttentionController {
	// ��ע
	@Resource(name = "attentionServiceImpl")
	private IAttentionService attentionService;

	/**
	 * �����ע
	 */
	@RequestMapping("user/addAttention")
	public String addAttention(String by_user_id, HttpServletRequest request) {
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		System.out.println("����ע��id==" + by_user_id);
		Attention attention = new Attention();
		// ����ע�˵�ID
		attention.setBy_user_id(Integer.valueOf(by_user_id));
		// ��ע��ID
		attention.setUser_id(loginUser.getId());
		attentionService.add_Attention(attention);
		return "redirect:/xianshi.htmlx";
	}

	/**
	 * ��ѯ��ע״̬
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
			// ����ѯ����ע���û�id�ŵ�attention_state
			attention_state = attentionService.query_guanzhu(loginUser.getId());
		}
		// ѭ��������ѯ��������
		if (attention_state != null) {
			for (Paper p : vo.getResult()) {
				// �ж�������ӵķ�����id���¼��id�Ƿ�һ�� һ������Ϊ�ѹ�ע
				for (Attention a : attention_state) {
					if (a.getBy_user_id() == Integer.valueOf(p.getUser_id())) {
						System.out.println(loginUser.getUname() + "��ע��" + a);
						p.setAttention_state(1);
						p.setAttention_id(a.getAttention_id());
					}
				}
			}
		}
		// ��ת��FabulousController
		return "forward:queryut.htmlx";
	}
	
	/**
	 * ���ȡ����ע
	 */
	@RequestMapping("user/delete_attention")
	public String delete_attention(String attention_id){
		System.out.println("ȡ����ע��ID="+attention_id);
		attentionService.deleteAttention(Integer.valueOf(attention_id));
		return "redirect:/xianshi.htmlx";
	}
	
	

}
