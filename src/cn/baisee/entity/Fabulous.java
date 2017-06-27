package cn.baisee.entity;

/**
 * 点赞表
 * @author Administrator
 *
 */
public class Fabulous {

	private int fabulous_id;//点赞id
	private int user_id;//点赞人id
	private int p_id;//被点赞帖子的id
	public int getFabulous_id() {
		return fabulous_id;
	}
	public void setFabulous_id(int fabulous_id) {
		this.fabulous_id = fabulous_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	
}
