package cn.baisee.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.entity.Feedback;
import cn.baisee.entity.User;
import cn.baisee.service.IFeedbackService;

/**
 * �û�����
 * @author Administrator
 *
 */
@Controller
public class FeedbackController {
	
	@Resource(name="feedbackServiceImpl")
	private IFeedbackService feedbackService;
	
	/**
	 * ����û�����
	 * @param request
	 * @param feedback
	 * @return
	 */
	@RequestMapping("user/add_feedback")
	public String add_feedback(HttpServletRequest request,Feedback feedback,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		feedback.setUser_id(loginUser.getId());
		System.out.println("������=="+feedback.getF_name());
		System.out.println("����email==="+feedback.getF_email());
		System.out.println("��������=="+feedback.getF_content());
		feedbackService.add_feedback(feedback);
		map.put("success", "���Գɹ�����л������ԣ�");
		return "contact";
	}

}
