package cn.baisee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {


	/**
	 * ��תҳ�� ��ת��PaperController�в�ѯ��¼�û��ղع�������
	 * @return
	 */
	@RequestMapping("user/personal")
	public String tiaozhuan(){
		return "forward:/user/queryshoucang.htmlx";
		//return "redirect:/personal/personal.jsp";
	}
	
}
