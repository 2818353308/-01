package cn.baisee.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.entity.Paper;
import cn.baisee.entity.Shoucang;
import cn.baisee.entity.User;
import cn.baisee.service.IShoucangService;
import cn.baisee.vo.PageVo;

/**
 * 收藏
 * @author Administrator
 *
 */
@Controller
public class ShoucangController {
	
	@Resource(name="shoucangServiceImpl")
	private IShoucangService shoucangService;
	
	/**
	 * 查询收藏信息
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("query_shoucang")
	public String query_shoucang(HttpServletRequest request,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			PageVo list =  (PageVo) request.getAttribute("paper");
			//查询出登录用户收藏帖子的id
			List<Shoucang> p_idList = shoucangService.queryS(loginUser.getId());
			for(Paper item:list.getResult()){
				for(Shoucang i:p_idList){
					if(item.getPost_id()==i.getPost_id()){
						item.setShoucang_state(1);
						item.setShoucang_id(i.getS_id());
					}
				}
			}
			map.put("paper", list);
		}
		return "archive";
	}
	
	/**
	 * 添加收藏
	 * @param request
	 * @param post_id
	 * @return
	 */
	/*@RequestMapping("user/add_shoucang")
	public String add_shoucang(HttpServletRequest request,String post_id){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		Shoucang shoucang=new Shoucang();
		shoucang.setPost_id(Integer.valueOf(post_id));
		shoucang.setUser_id(loginUser.getId());
		shoucangService.add_shoucang(shoucang);
		//跳转到
		return "redirect:/xianshi.htmlx";
	}*/
	
	//ajax添加收藏
	@RequestMapping("user/add_shoucang_ajax")
	public void add_shoucang2(HttpServletRequest request,String post_id){
		System.out.println("进入ajax收藏");
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		Shoucang shoucang=new Shoucang();
		shoucang.setPost_id(Integer.valueOf(post_id));
		shoucang.setUser_id(loginUser.getId());
		shoucangService.add_shoucang(shoucang);
	}
	
	/**
	 * 根据收藏ID删除一个收藏
	 */
	@RequestMapping("user/delete_shoucang_ajax")
	public void delete2(String s_id){
		System.out.println("删除收藏ID为="+s_id);
		shoucangService.delete_shoucang(Integer.valueOf(s_id));
	}
	
	/**
	 * 根据收藏ID删除一个收藏
	 */
	@RequestMapping("user/delete_shoucang")
	public String delete(String s_id){
		System.out.println("删除收藏ID为="+s_id);
		shoucangService.delete_shoucang(Integer.valueOf(s_id));
		return "redirect:/xianshi.htmlx";
	}

}
