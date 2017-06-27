package cn.baisee.entity;

/**
 * 收藏表
 * @author Administrator
 *
 */
public class Shoucang {

	private int s_id;//收藏id
	private int post_id;//被收藏帖子的id、
	private int user_id;//收藏人id
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
}
