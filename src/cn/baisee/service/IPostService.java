package cn.baisee.service;

import cn.baisee.entity.Gpaper;

/**
 * 业务逻辑层
 * @author Administrator
 *
 */
public interface IPostService {
/**
 * 管理员发帖方法
 */
	public Integer post(Gpaper gpaper);
	/**
	 * 删除管理员帖子
	 * @param g_id
	 * @return
	 */
	public Integer delete_gpost(Integer g_id);
}
