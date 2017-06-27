package cn.baisee.tags;


import cn.baisee.entity.User;
import cn.baisee.service.ICommentService;
import cn.baisee.service.IFabulousService;
import cn.baisee.service.IUserService;
import cn.baisee.utils.ContextUtils;

/**
 * �Զ���el
 * @author Administrator
 *
 */
public class Usereltag {
	
	/**
	 *�����û�ID��ѯ���û�����Ϣ
	 * @param id
	 * @return
	 */
	public static User quetyUser(Integer id){
		IUserService userService= (IUserService) ContextUtils.getContext().getBean("userServiceImpl");
		return userService.queryUser(id);
	}
	/**
	 * ��������ID��ѯ����������������
	 * @param p_id
	 * @return
	 */
	public static Integer comment_count(Integer p_id){
		ICommentService commentService = (ICommentService) ContextUtils.getContext().getBean("commentServiceImpl");
		return commentService.query_commentcount(p_id);
	}
	/**
	 * ��������ID��ѯ�����ӱ����޵ĸ���
	 */
	public static Integer querytotal(Integer p_id){
		IFabulousService fabulousService = (IFabulousService) ContextUtils.getContext().getBean("fabulousServiceImpl");
		return fabulousService.querytotal(p_id);
	}
	
}
