package cn.baisee.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.service.IUserService;
import cn.baisee.vo.PageVo;

@Controller
public class GUserController {
	@Resource(name="userServiceImpl")
	private IUserService iuserService;
	
	
	@RequestMapping("queryuser")
	public String query(ModelMap map) {
		PageVo pageVo = new PageVo();
		PageVo vo = iuserService.gchaxun7(pageVo);

		if (vo != null) {
			map.put("pageVo", vo);
			return "admin/guser";
		}
		return "admin/guser";
	}
}
