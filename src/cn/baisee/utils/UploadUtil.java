package cn.baisee.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传工具类
 * @author Administrator
 *
 */
public class UploadUtil {

	
	public static String uploadFile(HttpServletRequest request,String upload,MultipartFile file){
		//项目部署磁盘磁盘的根目录
		String realPath = request.getSession().getServletContext().getRealPath("/");
		//上传目录
		String uploadPath=realPath+upload;
		
		File uploadPathFile = new File(uploadPath);
		if (!uploadPathFile.exists()) {//判断该目录是否存在 不存在则创建该目录
			uploadPathFile.mkdirs();
		}
		// 获取上传文件的名称。
		String fileName = file.getOriginalFilename(); 
		String filePath=uploadPath+"/"+fileName;
		System.out.println("真实目录：" + realPath);
		try {// 转存文件
			file.transferTo(new File(filePath));
			String imgsrc=upload+"/"+fileName;
			return imgsrc;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return null;
		} // 将文件保存磁盘上。
	}
	
}
