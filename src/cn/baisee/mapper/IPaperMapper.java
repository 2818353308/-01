package cn.baisee.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import cn.baisee.entity.Paper;
import cn.baisee.vo.PageVo;

public interface IPaperMapper {

	/**
	 * 分页查询帖子
	 * @param pageVo
	 * @return
	 */
	public List<Paper> chaxun(PageVo pageVo);
	
	/**
	 * 添加帖子
	 * @param paper
	 * @return
	 */
	@Insert("insert into paper (post_type,post_content,post_image,post_time,user_id)values(#{post_type},#{post_content},#{post_image},#{post_time},#{user_id})")
	public Integer addPaper(Paper paper);
	
	/**
	 * 查询帖子总条数
	 * @param pageVo
	 * @return
	 */
	public Integer chaxuntiaoshu(PageVo pageVo);
	
	/**
	 * 删除帖子
	 * @param post_id帖子ID
	 * @return
	 */
	@Delete("delete from paper where post_id=#{post_id}")
	public Integer deletePaper(Integer post_id);
	
	
	/**
	 * 个中心查询出登录用户的收藏帖子
	 */
	//@Select("select * from paper,user  where paper.user_id=user.id and post_id in(select post_id from shoucang where user_id=#{user_id})")
	public List<Paper> queryshoucang(Integer user_id);
	
	/**
	 * 个人中心 登录用户发的帖子
	 * @param user_id
	 * @return
	 */
	public List<Paper> mypaper(Integer user_id);
			
}
