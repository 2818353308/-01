package cn.baisee.entity;

/**
 * 反馈表
 * @author Administrator
 *
 */
public class Feedback {

	private int f_id;//反馈id
	private int user_id;//反馈人id
	private String f_content;//反馈内容
	private String f_name;//反馈人姓名
	private String f_email;//反馈人email
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_email() {
		return f_email;
	}
	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
	
	
}
