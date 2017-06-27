package cn.baisee.service;

import java.util.List;

import cn.baisee.entity.Shoucang;
public interface IShoucangService {

	/**
	 * 根据登录用户id查询该用户所收藏的帖子id
	 * @param user_id
	 * @return
	 */
	public List<Shoucang> queryS(Integer user_id);
	/**
	 * 添加收藏
	 * @param shoucang
	 * @return
	 */
	public Integer add_shoucang(Shoucang shoucang);
	
	/**
	 * 根据收藏ID删除一条数据为取消收藏
	 */
	public Integer delete_shoucang(Integer s_id);
			
}
