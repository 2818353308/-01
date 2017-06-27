package cn.baisee.tags;


import cn.baisee.entity.User;
import cn.baisee.service.ICommentService;
import cn.baisee.service.IFabulousService;
import cn.baisee.service.IUserService;
import cn.baisee.utils.ContextUtils;

/**
 * 自定义el
 * @author Administrator
 *
 */
public class Usereltag {
	
	/**
	 *根据用户ID查询出用户的信息
	 * @param id
	 * @return
	 */
	public static User quetyUser(Integer id){
		IUserService userService= (IUserService) ContextUtils.getContext().getBean("userServiceImpl");
		return userService.queryUser(id);
	}
	/**
	 * 根据帖子ID查询出该贴的评论条数
	 * @param p_id
	 * @return
	 */
	public static Integer comment_count(Integer p_id){
		ICommentService commentService = (ICommentService) ContextUtils.getContext().getBean("commentServiceImpl");
		return commentService.query_commentcount(p_id);
	}
	/**
	 * 根据帖子ID查询该帖子被点赞的个数
	 */
	public static Integer querytotal(Integer p_id){
		IFabulousService fabulousService = (IFabulousService) ContextUtils.getContext().getBean("fabulousServiceImpl");
		return fabulousService.querytotal(p_id);
	}
	
}
