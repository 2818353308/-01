package cn.baisee.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * �ϴ�������
 * @author Administrator
 *
 */
public class UploadUtil {

	
	public static String uploadFile(HttpServletRequest request,String upload,MultipartFile file){
		//��Ŀ������̴��̵ĸ�Ŀ¼
		String realPath = request.getSession().getServletContext().getRealPath("/");
		//�ϴ�Ŀ¼
		String uploadPath=realPath+upload;
		
		File uploadPathFile = new File(uploadPath);
		if (!uploadPathFile.exists()) {//�жϸ�Ŀ¼�Ƿ���� �������򴴽���Ŀ¼
			uploadPathFile.mkdirs();
		}
		// ��ȡ�ϴ��ļ������ơ�
		String fileName = file.getOriginalFilename(); 
		String filePath=uploadPath+"/"+fileName;
		System.out.println("��ʵĿ¼��" + realPath);
		try {// ת���ļ�
			file.transferTo(new File(filePath));
			String imgsrc=upload+"/"+fileName;
			return imgsrc;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return null;
		} // ���ļ���������ϡ�
	}
	
}
