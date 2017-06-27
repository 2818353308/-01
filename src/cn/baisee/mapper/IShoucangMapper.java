package cn.baisee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.baisee.entity.Shoucang;



public interface IShoucangMapper {

	/**
	 * 根据登录用户id查询该用户所收藏的帖子id
	 * @param user_id
	 * @return
	 */
	@Select("select * from shoucang where user_id=#{user_id}")
	public List<Shoucang> queryS(Integer user_id);
	
	@Insert("insert into shoucang (post_id,user_id)values(#{post_id},#{user_id})")
	public Integer add_shoucang(Shoucang shoucang);
	
	/**
	 * 根据收藏ID删除一条数据为取消收藏
	 */
	@Delete("delete from shoucang where s_id=#{s_id}")
	public Integer delete_shoucang(Integer s_id);
	

			
}
