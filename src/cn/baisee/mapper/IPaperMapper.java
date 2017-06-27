package cn.baisee.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import cn.baisee.entity.Paper;
import cn.baisee.vo.PageVo;

public interface IPaperMapper {

	/**
	 * ��ҳ��ѯ����
	 * @param pageVo
	 * @return
	 */
	public List<Paper> chaxun(PageVo pageVo);
	
	/**
	 * �������
	 * @param paper
	 * @return
	 */
	@Insert("insert into paper (post_type,post_content,post_image,post_time,user_id)values(#{post_type},#{post_content},#{post_image},#{post_time},#{user_id})")
	public Integer addPaper(Paper paper);
	
	/**
	 * ��ѯ����������
	 * @param pageVo
	 * @return
	 */
	public Integer chaxuntiaoshu(PageVo pageVo);
	
	/**
	 * ɾ������
	 * @param post_id����ID
	 * @return
	 */
	@Delete("delete from paper where post_id=#{post_id}")
	public Integer deletePaper(Integer post_id);
	
	
	/**
	 * �����Ĳ�ѯ����¼�û����ղ�����
	 */
	//@Select("select * from paper,user  where paper.user_id=user.id and post_id in(select post_id from shoucang where user_id=#{user_id})")
	public List<Paper> queryshoucang(Integer user_id);
	
	/**
	 * �������� ��¼�û���������
	 * @param user_id
	 * @return
	 */
	public List<Paper> mypaper(Integer user_id);
			
}
