package cn.baisee.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Paper {

	private int post_id;//发帖id
	private String post_type;//发帖类型
	private String post_content;//发帖内容
	private String post_image;//图片
	private Date post_time;//发帖时间
	private String user_id;//发帖人id
	
	
	private int state=0;//点赞状态
	private int attention_state=0;//该发帖人是否被关注 0为未关注1已关注
	private int attention_id=0;//关注表ID
	private int shoucang_state=0;//收藏状态
	private int shoucang_id=0;//收藏表ID
	
	
	private List<Comment> list_Comment;//评论内容
	
	private User user;//发送帖子的人
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	
	public String getPost_image() {
		return post_image;
	}
	public void setPost_image(String post_image) {
		this.post_image = post_image;
	}
	public String getPost_time() {
		//转化日期格式化 yyyy MM dd hh mm ss SSS
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String result = format.format(post_time);
		return result;
	}
	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<Comment> getList_Comment() {
		return list_Comment;
	}
	public void setList_Comment(List<Comment> list_Comment) {
		this.list_Comment = list_Comment;
	}
	public int getAttention_state() {
		return attention_state;
	}
	public void setAttention_state(int attention_state) {
		this.attention_state = attention_state;
	}
	public int getShoucang_state() {
		return shoucang_state;
	}
	public void setShoucang_state(int shoucang_state) {
		this.shoucang_state = shoucang_state;
	}
	public int getShoucang_id() {
		return shoucang_id;
	}
	public void setShoucang_id(int shoucang_id) {
		this.shoucang_id = shoucang_id;
	}
	public int getAttention_id() {
		return attention_id;
	}
	public void setAttention_id(int attention_id) {
		this.attention_id = attention_id;
	}
	
	
	
	
	
}
