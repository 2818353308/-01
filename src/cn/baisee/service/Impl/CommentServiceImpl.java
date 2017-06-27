package cn.baisee.service.Impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Comment;
import cn.baisee.mapper.ICommentMapper;
import cn.baisee.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Resource(name="ICommentMapper")
	ICommentMapper commentMapper;

	@Override
	public List<Comment> query_comment(Integer p_id) {
		return commentMapper.query_comment(p_id);
	}

	@Override
	public Integer add_comment(String p_id, int user_id, String c_content) {
		Comment comment=new Comment();
		comment.setP_id(Integer.valueOf(p_id));
		comment.setUser_id(Integer.valueOf(user_id));
		comment.setC_content(c_content);
		return commentMapper.add_comment(comment);
	}

	@Override
	public Integer query_commentcount(Integer p_id) {
		return commentMapper.query_commentcount(p_id);
	}

	@Override
	public Integer delete(String c_id) {
		return commentMapper.delete(Integer.valueOf(c_id));
	}
	
	

}
