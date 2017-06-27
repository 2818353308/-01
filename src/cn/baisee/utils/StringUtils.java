package cn.baisee.utils;

import java.util.UUID;

import org.springframework.util.DigestUtils;

/**
 * String ������
 * @author Administrator
 *
 */
public class StringUtils {

	
	/**
	 * ����uuid
	 * @return
	 */
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 
	 * @param md5�����ַ���
	 * @return
	 */
	public static String encodeMd5(String md5){
		return DigestUtils.md5DigestAsHex(md5.getBytes());
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(encodeMd5("520520"));
	}
	
}
