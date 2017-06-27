package cn.baisee.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.baisee.entity.Guser;
import cn.baisee.service.IGaddService;
import cn.baisee.utils.UploadUtil;


/**
 * 管理员新增Controller
 * 
 * @author Administrator
 *
 */
@Controller
public class GAddController {
	@Resource(name="addServiceImpl")
	private IGaddService gaddService;
	
	
	@RequestMapping("gadd")
	public String post(Guser guser, ModelMap map, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("fiels") MultipartFile file) throws Exception {
		
		if(!file.getOriginalFilename().equals("")){
		 	String imgagPath = UploadUtil.uploadFile(request, "gpaper", file);
		 	guser.setGuan_image(imgagPath);
		}	
		gaddService.gadd(guser);
		
		
		return "admin:/gadd.jsp";
	}
	
}
