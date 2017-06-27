package cn.baisee.controller;
import java.io.IOException; 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import cn.baisee.entity.Gpaper;
import cn.baisee.entity.Guser;
import cn.baisee.service.IPostService;
import cn.baisee.utils.UploadUtil;



/**
 * ����Ա����Controller
 * 
 * @author Administrator
 *
 */
@Controller
public class GPostController {
	
	@Resource(name="postServiceImpl")
	private IPostService postService;
	/**
	 * �ϴ�����
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	
	@RequestMapping("post")
	public String post(Gpaper gpaper, ModelMap map, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("fiels") MultipartFile file) throws Exception {
		if(!file.getOriginalFilename().equals("")){
		 	String imgagPath = UploadUtil.uploadFile(request, "gpaper", file);
		 	gpaper.setG_image(imgagPath);
		}
		postService.post(gpaper);
		Guser gloginUser = (Guser) request.getSession().getAttribute("gloginUser");
	 	gpaper.setGid(String.valueOf(gloginUser.getId()));
	 	postService.post(gpaper);
		return "redirect:/query.htmlx";
	}
	
	/**
	 * ɾ������Ա������
	 */
	@RequestMapping("admin/delete_gpost")
	public String delete_gpost(String g_id){
		System.out.println("ɾ������Ա������id="+g_id);
		postService.delete_gpost(Integer.valueOf(g_id));
		return "redirect:/query.htmlx";
	}

}
