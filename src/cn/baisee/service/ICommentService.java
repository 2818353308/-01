package cn.baisee.service;

import java.util.List;

import cn.baisee.entity.Comment;


/**
 * ����ҵ���߼���
 */
public interface ICommentService {
	
	public List<Comment> query_comment(Integer p_id);

	public Integer add_comment(String p_id,int user_id,String c_content);
	
	/**
	 * ��������ID��ѯ��������
	 * @param p_id
	 * @return
	 */
	public Integer query_commentcount(Integer p_id);
	/**
	 * ��������IDɾ������
	 */
	public Integer delete(String c_id);
	
}
