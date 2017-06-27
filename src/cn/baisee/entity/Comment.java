package cn.baisee.entity;

/**
 * 评论表
 * @author Administrator
 *
 */
public class Comment {

	private int c_id;//评论id
	private int p_id;//外键 被评论帖子的id
	private int user_id;//外键 评论者id
	private String c_content;//评论内容
	
	private User user;//评论者信息
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
