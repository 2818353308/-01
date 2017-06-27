package cn.baisee.entity;

public class User {
	
	private Integer id;
	private String uname;
	private String upass;
	private String sex;
	private String head_portrait;//Í·Ïñ
	
	public User() {
	}
	public User(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHead_portrait() {
		return head_portrait;
	}
	public void setHead_portrait(String head_portrait) {
		this.head_portrait = head_portrait;
	}

}
