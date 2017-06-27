package cn.baisee.service;

import java.util.List;

import cn.baisee.entity.Comment;


/**
 * 评论业务逻辑层
 */
public interface ICommentService {
	
	public List<Comment> query_comment(Integer p_id);

	public Integer add_comment(String p_id,int user_id,String c_content);
	
	/**
	 * 根据帖子ID查询评论条数
	 * @param p_id
	 * @return
	 */
	public Integer query_commentcount(Integer p_id);
	/**
	 * 根据评论ID删除评论
	 */
	public Integer delete(String c_id);
	
}
