package cn.baisee.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gpaper implements Serializable {
	/**
	 * 管理员封装类
	 */
	private static final long serialVersionUID = 522280137869724854L;
	private int g_id;
	private String g_type;
	private String g_content;
	private String g_image;
	private Date g_time;
	private String gid;
	private Guser guser;
	private User user;//发送帖子的人
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gpaper() {
	}

	public Gpaper(String g_type, String g_content, String g_image, Date g_time) {

		this.g_type = g_type;
		this.g_content = g_content;
		this.g_image = g_image;
		this.g_time = g_time;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getG_type() {
		return g_type;
	}

	public void setG_type(String g_type) {
		this.g_type = g_type;
	}

	public String getG_content() {
		return g_content;
	}

	public void setG_content(String g_content) {
		this.g_content = g_content;
	}

	public String getG_image() {
		return g_image;
	}

	public void setG_image(String g_image) {
		this.g_image = g_image;
	}

	public String getG_time() {
		// 转化日期格式化 yyyy MM dd hh mm ss SSS
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String result = format.format(g_time);
		return result;
	}

	public void setG_time(Date g_time) {
		this.g_time = g_time;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public Guser getGuser() {
		return guser;
	}

	public void setGuser(Guser guser) {
		this.guser = guser;
	}




}
