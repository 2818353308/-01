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
 * 认证码
 */
@Controller
public class CodeController {
	
	@RequestMapping("loginVCode")
	public void login(HttpServletRequest request,HttpServletResponse response){
		ImageCodeUtil utils=ImageCodeUtil.getInstance();
		//图片认证码
		BufferedImage codeImg=utils.getRandcode();
		//获取生成的字符串
		String code=utils.getCode();
		//存入Session当中
		request.getSession().setAttribute("loginVCode", code);
		try {
			//输出图片内容
			ImageIO.write(codeImg,"jpg",response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
