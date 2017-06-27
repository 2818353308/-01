package cn.baisee.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.entity.Paper;
import cn.baisee.entity.User;
import cn.baisee.service.IFabulousService;
import cn.baisee.vo.PageVo;

/**
 * 点赞Controller
 * @author Administrator
 *
 */
@Controller
public class FabulousController {
	
	@Resource(name="fabulousServiceImpl")
	private IFabulousService fabulousService;
	
	

	/**
	 * 查询用户是否点赞  查询
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("queryut")
	public String queryut(HttpServletRequest request,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			int uid=loginUser.getId();
			//查询出登录用户点过帖子的id
			List<Integer> pids=fabulousService.queryut(uid);
			PageVo list =  (PageVo) request.getAttribute("paper");
			//使用双重循环  给点过帖子的state状态改为1；0为未赞，1为已赞
			for(Paper p:list.getResult()){
				for(Integer i:pids){
					if(p.getPost_id()==i){
						p.setState(1);
					}
				}
			}
			map.put("paper", list);
			return "forward:query_shoucang.htmlx";
		}
		//跳转到ShoucangController
		return "forward:query_shoucang.htmlx";
	}
	
	/**
	 * 点赞
	 * @return
	 */
	@RequestMapping("user/dianzan")
	public String save(String t_id,HttpServletRequest request){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		System.out.println("用户-============="+loginUser);
		fabulousService.save(Integer.valueOf(loginUser.getId()),Integer.valueOf(t_id));
		return "redirect:/xianshi.htmlx";
	}
	
	
	/**
	 * 查询该用户是否点过该帖子
	 * @param user_id
	 * @param p_id
	 * @return
	 */
	//@ResponseBody
	/*@RequestMapping("chazan")
	public String c(HttpServletRequest request,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			PageVo list =  (PageVo) request.getAttribute("paper");
			for(Paper item:list.getResult()){
				System.out.println("发帖id"+item.getPost_id());
				System.out.println("用户名"+loginUser.getUname());
				//第一个参数为点赞人id  第二个为帖子id 查询该用户是否点过赞 
				Fabulous fabulous = fabulousService.chazan(loginUser.getId(),item.getPost_id());
				//判断该用户是否点过赞 点过赞则把state的状态改为1
				if(fabulous!=null){
					System.out.println("已赞");
					item.setState(1);
				}else{
					System.out.println("未赞");
				}
			}
			map.put("paper", list);
		}
		return "forward:query_shoucang.htmlx";
	}*/
}
