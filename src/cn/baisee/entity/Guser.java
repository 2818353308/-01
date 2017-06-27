package cn.baisee.entity;

import java.io.Serializable;


public class Guser implements Serializable {

	private static final long serialVersionUID = 1404786889149786998L;
	private int id;
	private String uname;
	private String upass;

	
	public Guser() {
	}
	public Guser(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}
		
	private String guan_image;
	public Guser(String uname, String upass, String guan_image) {
		this.uname = uname;
		this.upass = upass;
		this.guan_image = guan_image;
	}
	public String getGuan_image() {
		return guan_image;
	}
	public void setGuan_image(String guan_image) {
		this.guan_image = guan_image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	

}
