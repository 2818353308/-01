package cn.baisee.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import cn.baisee.entity.User;
import cn.baisee.service.IUserService;
import cn.baisee.utils.StringUtils;
import cn.baisee.utils.UploadUtil;

@SessionAttributes({"loginUser"})
@Controller
public class UserController {
	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@RequestMapping("login")
	public String login(User user,ModelMap map){
		User LoginUser = userService.login(user);
		if(LoginUser==null){
			map.put("error", "�������");
			return "login";
		}
		map.put("loginUser", LoginUser);
		//request.getSession().setAttribute("loginUser", LoginUser);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("register")
	public String register(String vcode,User user,ModelMap map,@RequestParam(name="touxiang",required=false) MultipartFile file,HttpServletRequest request){
		if(user==null||user.getUname()==null||user.getUpass()==null){
			map.put("error", "�û��������벻��Ϊ��");
			return "register";
		}
		String loginVCode=String.valueOf(request.getSession().getAttribute("loginVCode"));
		if(loginVCode==null||vcode==null||!vcode.equalsIgnoreCase(loginVCode)){
			map.addAttribute("error", "��֤�����");
			return "forward:/register.jsp";
		}
		User querySessionUser=userService.queryUserByUserName(user.getUname());
		//�жϸ��û��Ƿ���� ��������ע��
		if(querySessionUser==null){
			//�ж�ͷ���Ƿ�Ϊ�� ���Ϊ���򷵻�����ע��
			if(!file.getOriginalFilename().equals("")){
				String head_portrait = UploadUtil.uploadFile(request, "touxiang", file);
				user.setHead_portrait(head_portrait);
				System.out.println("�ϴ�ͼƬ=="+head_portrait);
			}else{
				map.put("error", "��ѡ��ͷ��");
				return "register";
			}
			//����ע��
			userService.saveRegister(user);
			return "login";
		}else{
			//���������ص�ҳ��  �����û����û��Ѵ���
			map.put("error", "�û����Ѵ��ڣ�");
			return "register";
		}
	}
	
	@RequestMapping("modify_pass")
	public String modify_pass(String jupass,String xupass,HttpServletRequest request,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			map.put("error", "���ȵ�¼��");
			return "login";
		}
		System.out.println("������"+jupass+loginUser.getUpass());
		System.out.println("������"+xupass);
		if(!loginUser.getUpass().equals(StringUtils.encodeMd5(jupass))){
			map.put("error", "������������������룡");
			return "modify_pass";
		}else{
			//�����޸�����
			userService.modify_pass(xupass, loginUser.getId());
			map.put("error", "�����Ѿ��޸������µ�¼��");
			return "login";
		}
	}
	
	/**
	 * �˳���¼
	 */
	@RequestMapping("logout")
	public String logout(SessionStatus sessionStatus){
		if(!sessionStatus.isComplete()){
			//����Session
			sessionStatus.setComplete();
		}
		return "redirect:index.jsp";
	}
	
	
}
