package cn.baisee.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Feedback;
import cn.baisee.mapper.IFeedbackMapper;
import cn.baisee.service.IFeedbackService;

/**
 * ”√ªß∑¥¿°
 * @author Administrator
 *
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService {
	
	@Resource(name="IFeedbackMapper")
	private IFeedbackMapper feedbackMapper;

	@Override
	public Integer add_feedback(Feedback feedback) {
		
		return feedbackMapper.add_feedback(feedback);
	}

}
