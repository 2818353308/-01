package cn.baisee.entity;

/**
 * ���۱�
 * @author Administrator
 *
 */
public class Comment {

	private int c_id;//����id
	private int p_id;//��� ���������ӵ�id
	private int user_id;//��� ������id
	private String c_content;//��������
	
	private User user;//��������Ϣ
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
