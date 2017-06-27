package cn.baisee.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.baisee.entity.Fabulous;

public interface IFabulousMapper {
	/**
	 * 查询到用户点赞过的帖子id
	 * @param uid
	 * @return
	 */
	public Fabulous chazan(Fabulous fabulous);

	/**
	 * 查询到用户点赞过的帖子id
	 * @param uid
	 * @return
	 */
	@Select("select p_id from fabulous where user_id=#{uid}")
	public List<Integer> queryut(Integer uid);
	
	@Insert("insert into fabulous (user_id,p_id)values(#{user_id},#{p_id})")
	public Integer save(Map<String, Object> map);
	/**
	 * 查询这个帖子被赞个数
	 */
	@Select("select count(*) from fabulous where p_id=#{p_id}")
	public Integer querytotal(Integer p_id);
}
