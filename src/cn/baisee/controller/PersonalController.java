package cn.baisee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {


	/**
	 * 跳转页面 跳转到PaperController中查询登录用户收藏过得帖子
	 * @return
	 */
	@RequestMapping("user/personal")
	public String tiaozhuan(){
		return "forward:/user/queryshoucang.htmlx";
		//return "redirect:/personal/personal.jsp";
	}
	
}
