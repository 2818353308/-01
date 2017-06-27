package cn.baisee.entity;
/**
 * 关注表
 * @author Administrator
 *
 */
public class Attention {
	
	private int attention_id;//关注id
	
	private int by_user_id;//被关注人id
	
	private int user_id;//关注人id

	public int getAttention_id() {
		return attention_id;
	}

	public void setAttention_id(int attention_id) {
		this.attention_id = attention_id;
	}

	public int getBy_user_id() {
		return by_user_id;
	}

	public void setBy_user_id(int by_user_id) {
		this.by_user_id = by_user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

}
