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
 * ����Controller
 * @author Administrator
 *
 */
@Controller
public class FabulousController {
	
	@Resource(name="fabulousServiceImpl")
	private IFabulousService fabulousService;
	
	

	/**
	 * ��ѯ�û��Ƿ����  ��ѯ
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("queryut")
	public String queryut(HttpServletRequest request,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			int uid=loginUser.getId();
			//��ѯ����¼�û�������ӵ�id
			List<Integer> pids=fabulousService.queryut(uid);
			PageVo list =  (PageVo) request.getAttribute("paper");
			//ʹ��˫��ѭ��  ��������ӵ�state״̬��Ϊ1��0Ϊδ�ޣ�1Ϊ����
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
		//��ת��ShoucangController
		return "forward:query_shoucang.htmlx";
	}
	
	/**
	 * ����
	 * @return
	 */
	@RequestMapping("user/dianzan")
	public String save(String t_id,HttpServletRequest request){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		System.out.println("�û�-============="+loginUser);
		fabulousService.save(Integer.valueOf(loginUser.getId()),Integer.valueOf(t_id));
		return "redirect:/xianshi.htmlx";
	}
	
	
	/**
	 * ��ѯ���û��Ƿ���������
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
				System.out.println("����id"+item.getPost_id());
				System.out.println("�û���"+loginUser.getUname());
				//��һ������Ϊ������id  �ڶ���Ϊ����id ��ѯ���û��Ƿ����� 
				Fabulous fabulous = fabulousService.chazan(loginUser.getId(),item.getPost_id());
				//�жϸ��û��Ƿ����� ��������state��״̬��Ϊ1
				if(fabulous!=null){
					System.out.println("����");
					item.setState(1);
				}else{
					System.out.println("δ��");
				}
			}
			map.put("paper", list);
		}
		return "forward:query_shoucang.htmlx";
	}*/
}
