package cn.baisee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.baisee.entity.Comment;

/**
 * 评论区
 * @author Administrator
 *
 */
public interface ICommentMapper {

	/**
	 * 根据帖子的id查询这个帖子的评论
	 * @param p_id
	 * @return
	 * select * from comment,user where p_id=1  and comment.user_id=user.id
	 */
	public List<Comment> query_comment(Integer p_id);
	
	/**
	 * 添加评论
	 */
	@Insert("insert into comment (p_id,user_id,c_content)values(#{p_id},#{user_id},#{c_content})")
	public Integer add_comment(Comment comment);
	
	@Select("select count(*) from comment where p_id=#{p_id}")
	public Integer query_commentcount(Integer p_id);
	
	/**
	 * 根据评论ID删除评论
	 */
	@Delete("delete from comment where c_id=#{c_id}")
	public Integer delete(Integer c_id);
	
	
}
