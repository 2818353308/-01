package cn.baisee.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 图片认证码工具类
 * 
 * @author Administrator
 *
 */
public class ImageCodeUtil {

	private static ImageCodeUtil imageCodeUtil;

	private ImageCodeUtil() {
	}

	/**
	 * 单利构造
	 * 
	 * @return
	 */
	public static ImageCodeUtil getInstance() {
		if (imageCodeUtil == null) {
			imageCodeUtil = new ImageCodeUtil();
		}
		return imageCodeUtil;
	}

	private Random random = new Random();
	private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 随机产生的字符串

	private int width = 80;// 图片宽
	private int height = 26;// 图片高
	private int lineSize = 40;// 干扰线数量
	private int stringNum = 4;// 随机产生字符数量
	private String code;// 验证码Code

	/**
	 * 生成随机图片
	 */
	public BufferedImage getRandcode() {
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		// 参数分别为：宽、高、图片类型
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		// 简称画笔
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象，该对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, width, height);// 设定一个画的区域
		// 设置画的字体和大小
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));// 设置画的字体和大小
		// 设置字体随机颜色
		g.setColor(getRandColor(110, 133));
		// 绘制干扰线
		for (int i = 0; i <= lineSize; i++) {
			drowLine(g);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = drowString(g, randomString, i);
		}

		code = randomString;
		g.dispose();
		return image;

	}

	/**
	 * 绘制字符串
	 */
	private String drowString(Graphics g, String randomString, int i) {
		// 设置画的字体
		g.setFont(getFont());
		// 设置随机的RGB颜色
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
		// 获取随机字符
		String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));

		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));

		g.drawString(rand, 13 * i, 16);

		return randomString;

	}


	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}

	/**
	 * 获得颜色
	 */
	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc - 16);
		int g = fc + random.nextInt(bc - fc - 14);
		int b = fc + random.nextInt(bc - fc - 18);

		return new Color(r, g, b);
	}

	/**
	 * 绘制干扰线
	 */
	private void drowLine(Graphics g) {

		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);

		g.drawLine(x, y, x + xl, y + yl);
	}

	/*
	 * 获取随机的字符
	 */
	private String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCode() {
		return code;
	}
	
}
