package cn.baisee.service;

import java.util.List;



import cn.baisee.entity.Paper;
import cn.baisee.vo.PageVo;


/**
 * 帖子业务逻辑层
 */
public interface IPaperService {

	public List<Paper> chaxun(PageVo pageVo);
	
	public Integer addPaper(Paper paper);
	
	public PageVo chaxun2(PageVo pageVo);
	/**
	 * 删除帖子
	 * @param post_id帖子ID
	 * @return
	 */
	public Integer deletePaper(Integer post_id);
	
	
	/**
	 * 跟中心查询出登录用户的收藏帖子
	 */
	public List<Paper> queryshoucang(Integer user_id);
	
	/**
	 * 个人中心 登录用户发的帖子
	 * @param user_id
	 * @return
	 */
	public List<Paper> mypaper(Integer user_id);
	
}
