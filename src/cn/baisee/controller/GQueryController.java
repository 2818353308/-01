package cn.baisee.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.service.IGQueryService;
import cn.baisee.vo.PageVo;

/**
 * 查询所有的管理员
 * 
 * @author Administrator
 *
 */

@Controller
public class GQueryController {

	@Resource(name = "GQueryServiceImpl")
	private IGQueryService igqueryService;

	@RequestMapping("query1")
	public String query(ModelMap map) {
		PageVo pageVo = new PageVo();
		PageVo vo = igqueryService.gchaxun3(pageVo);
		if (vo != null) {
			map.put("pageVo", vo);
			return "admin/query";
		}
		return "admin/query";
	}
	
	

}
