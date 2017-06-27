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
 * 用户反馈
 * @author Administrator
 *
 */
@Controller
public class FeedbackController {
	
	@Resource(name="feedbackServiceImpl")
	private IFeedbackService feedbackService;
	
	/**
	 * 添加用户反馈
	 * @param request
	 * @param feedback
	 * @return
	 */
	@RequestMapping("user/add_feedback")
	public String add_feedback(HttpServletRequest request,Feedback feedback,ModelMap map){
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		feedback.setUser_id(loginUser.getId());
		System.out.println("反馈人=="+feedback.getF_name());
		System.out.println("反馈email==="+feedback.getF_email());
		System.out.println("反馈内容=="+feedback.getF_content());
		feedbackService.add_feedback(feedback);
		map.put("success", "留言成功，感谢你的留言！");
		return "contact";
	}

}
