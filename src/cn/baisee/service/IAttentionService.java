package cn.baisee.service;


import java.util.List;

import cn.baisee.entity.Attention;

/**
 * 关注
 * @author Administrator
 *
 */
public interface IAttentionService {

	/**
	 * 根据登录用户ID查询被关注人
	 * @param user_id
	 * @return
	 */
	public List<Attention> query_guanzhu(Integer user_id);
			
	/**
	 * 添加关注
	 * @param attention
	 * @return
	 */
	public Integer add_Attention(Attention attention);
	
	public Integer deleteAttention(Integer attention_id);
}
