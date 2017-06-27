package cn.baisee.mapper;


import org.apache.ibatis.annotations.Insert;

import cn.baisee.entity.Feedback;

/***
 * ”√ªß∑¥¿°
 * @author Administrator
 *
 */
public interface IFeedbackMapper {

	
	@Insert("insert into feedback (user_id,f_content,f_name,f_email)values(#{user_id},#{f_content},#{f_name},#{f_email})")
	public Integer add_feedback(Feedback feedback);
			
}
