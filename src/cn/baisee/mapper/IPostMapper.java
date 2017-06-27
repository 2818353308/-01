package cn.baisee.mapper;

import org.apache.ibatis.annotations.Delete;

import cn.baisee.entity.Gpaper;

public interface IPostMapper {
	/**
	 * ��������
	 */
	public Integer post(Gpaper gpaper);
	
	/**
	 * ɾ������
	 * @param g_id
	 * @return
	 */
	@Delete("delete from Gpaper where g_id=#{g_id}")
	public Integer delete_gpost(Integer g_id);
}
