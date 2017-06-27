package cn.baisee.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.utils.ImageCodeUtil;

/*
 * ��֤��
 */
@Controller
public class CodeController {
	
	@RequestMapping("loginVCode")
	public void login(HttpServletRequest request,HttpServletResponse response){
		ImageCodeUtil utils=ImageCodeUtil.getInstance();
		//ͼƬ��֤��
		BufferedImage codeImg=utils.getRandcode();
		//��ȡ���ɵ��ַ���
		String code=utils.getCode();
		//����Session����
		request.getSession().setAttribute("loginVCode", code);
		try {
			//���ͼƬ����
			ImageIO.write(codeImg,"jpg",response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
