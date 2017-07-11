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
 * �ղ�
 * @author Administrator
 *
 */
@Controller
public class ShoucangController {
	
	@Resource(name="shoucangServiceImpl")
	private IShoucangService shoucangService;
	
	/**
	 * ��ѯ�ղ���Ϣ
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("query_shoucang")
	public String query_shoucang(HttpServletRequest request,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			PageVo list =  (PageVo) request.getAttribute("paper");
			//��ѯ����¼�û��ղ����ӵ�id
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
	 * ����ղ�
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
		//��ת��
		return "redirect:/xianshi.htmlx";
	}*/
	
	//ajax����ղ�
	@RequestMapping("user/add_shoucang_ajax")
	public void add_shoucang2(HttpServletRequest request,String post_id){
		System.out.println("����ajax�ղ�");
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		Shoucang shoucang=new Shoucang();
		shoucang.setPost_id(Integer.valueOf(post_id));
		shoucang.setUser_id(loginUser.getId());
		shoucangService.add_shoucang(shoucang);
	}
	
	/**
	 * �����ղ�IDɾ��һ���ղ�
	 */
	@RequestMapping("user/delete_shoucang_ajax")
	public void delete2(String s_id){
		System.out.println("ɾ���ղ�IDΪ="+s_id);
		shoucangService.delete_shoucang(Integer.valueOf(s_id));
	}
	
	/**
	 * �����ղ�IDɾ��һ���ղ�
	 */
	@RequestMapping("user/delete_shoucang")
	public String delete(String s_id){
		System.out.println("ɾ���ղ�IDΪ="+s_id);
		shoucangService.delete_shoucang(Integer.valueOf(s_id));
		return "redirect:/xianshi.htmlx";
	}

}
