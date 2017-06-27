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
			map.put("error", "密码错误！");
			return "login";
		}
		map.put("loginUser", LoginUser);
		//request.getSession().setAttribute("loginUser", LoginUser);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("register")
	public String register(String vcode,User user,ModelMap map,@RequestParam(name="touxiang",required=false) MultipartFile file,HttpServletRequest request){
		if(user==null||user.getUname()==null||user.getUpass()==null){
			map.put("error", "用户名和密码不能为空");
			return "register";
		}
		String loginVCode=String.valueOf(request.getSession().getAttribute("loginVCode"));
		if(loginVCode==null||vcode==null||!vcode.equalsIgnoreCase(loginVCode)){
			map.addAttribute("error", "认证码错误");
			return "forward:/register.jsp";
		}
		User querySessionUser=userService.queryUserByUserName(user.getUname());
		//判断该用户是否存在 不存在则注册
		if(querySessionUser==null){
			//判断头像是否为空 如果为空则返回重新注册
			if(!file.getOriginalFilename().equals("")){
				String head_portrait = UploadUtil.uploadFile(request, "touxiang", file);
				user.setHead_portrait(head_portrait);
				System.out.println("上传图片=="+head_portrait);
			}else{
				map.put("error", "请选择头像！");
				return "register";
			}
			//继续注册
			userService.saveRegister(user);
			return "login";
		}else{
			//带参数返回到页面  告诉用户该用户已存在
			map.put("error", "用户名已存在！");
			return "register";
		}
	}
	
	@RequestMapping("modify_pass")
	public String modify_pass(String jupass,String xupass,HttpServletRequest request,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			map.put("error", "请先登录！");
			return "login";
		}
		System.out.println("旧密码"+jupass+loginUser.getUpass());
		System.out.println("新密码"+xupass);
		if(!loginUser.getUpass().equals(StringUtils.encodeMd5(jupass))){
			map.put("error", "旧密码错误，请重新输入！");
			return "modify_pass";
		}else{
			//进行修改密码
			userService.modify_pass(xupass, loginUser.getId());
			map.put("error", "密码已经修改请重新登录！");
			return "login";
		}
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping("logout")
	public String logout(SessionStatus sessionStatus){
		if(!sessionStatus.isComplete()){
			//消除Session
			sessionStatus.setComplete();
		}
		return "redirect:index.jsp";
	}
	
	
}
