package cn.baisee.utils;

import java.util.UUID;

import org.springframework.util.DigestUtils;

/**
 * String 工具类
 * @author Administrator
 *
 */
public class StringUtils {

	
	/**
	 * 生成uuid
	 * @return
	 */
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 
	 * @param md5加密字符串
	 * @return
	 */
	public static String encodeMd5(String md5){
		return DigestUtils.md5DigestAsHex(md5.getBytes());
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(encodeMd5("520520"));
	}
	
}
