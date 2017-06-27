package cn.baisee.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.baisee.entity.Guser;
import cn.baisee.service.IUserService;
@SessionAttributes({"gloginUser","adminerror"})
@Controller
public class GLoginController {
	@Resource(name="userServiceImpl")
	private IUserService userService;
	@RequestMapping("glogin")
	public String login(Guser guser,ModelMap map){	
		Guser gloginUser=userService.glogin(guser.getUname(),guser.getUpass());
		if (gloginUser != null) {
			map.put("gloginUser", gloginUser);
			return "redirect:/admin/jsp/main.jsp";
		} else {
			map.put("adminerror","管理员用户名或密码错误！");
			return "redirect:/admin/glogin.jsp";
		}
	}
}
