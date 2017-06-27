package cn.baisee.entity;

import java.io.Serializable;

public class Analysis implements Serializable{

	private static final long serialVersionUID = -1870360262043020839L;
	
	private Integer id;
	private String url;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
