package cn.baisee.service;

import java.util.List;

import cn.baisee.entity.Fabulous;

/**
 * 点赞业务逻辑层
 */
public interface IFabulousService {

	public Fabulous chazan(int user_id,int p_id);

	public List<Integer> queryut(Integer uid);
	
	/**
	 * 点赞
	 * @param user_id
	 * @param p_id
	 * @return
	 */
	public Integer save(Integer user_id,Integer p_id);
	/**
	 * 查询该帖子被点过多少赞
	 */
	public Integer querytotal(Integer p_id);
}
