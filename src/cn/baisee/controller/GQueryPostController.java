package cn.baisee.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.service.IQueryPostService;
import cn.baisee.vo.PageVo;

/**
 * 管理员发表的帖子
 * 
 * @author Administrator
 *
 */
@Controller
public class GQueryPostController {

	@Resource(name = "queryPostServiceImpl")
	private IQueryPostService queryPostService;

	private PageVo pageVo;

	@ModelAttribute
	public void init(PageVo pageVo) {
		this.pageVo = pageVo;
	}

	/**
	 * 查询所有管理员发表的帖子
	 * 
	 * @param request
	 * @param gpaper
	 * @param map
	 * @return
	 */
	@RequestMapping("query")
	public String query(ModelMap map) {
		PageVo vo = queryPostService.gchaxun2(pageVo);
		if (vo != null) {
			map.put("gpaper", vo);
			return "admin/querypost";
		}
		return "admin/querypost";
	}
	
	/**
	 * 查询管理员的帖子
	 */
	@RequestMapping("queryGpost")
	public String queryGpost(ModelMap map){
		PageVo vo = queryPostService.gchaxun2(pageVo);
		map.put("pageVo", vo);
		return "archive2";
	}

}