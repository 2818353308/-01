package cn.baisee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.baisee.entity.Attention;


public interface IAttentionMapper {//by_user_id

	@Select("select * from attention where user_id=#{user_id}")
	public List<Attention> query_guanzhu(Integer user_id);
	
	
	/*public List<User> query_guanzhuUser();*/
	
	@Insert("insert into attention (by_user_id,user_id)values(#{by_user_id},#{user_id})")
	public Integer add_Attention(Attention attention);
	
	/**
	 * È¡Ïû¹Ø×¢
	 */
	@Delete("delete from attention where attention_id=#{attention_id}")
	public Integer deleteAttention(Integer attention_id);
			
}
