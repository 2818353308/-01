package cn.baisee.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.baisee.entity.Guser;
import cn.baisee.entity.User;
import cn.baisee.vo.PageVo;

/**
 * 用户业务逻辑层
 */
public interface IUserService {

	/**
	 * 登录
	 */
	public User login(User user);
	
	public void saveRegister(User user);
	/*
	 * 根据用户名查询用户
	 */
	public User queryUserByUserName(String uname);
	
	/**
	 * 修改密码
	 */
	public Integer modify_pass(String xupass,int id);
	
	/**
	 * 根据ID查询用户
	 * @return
	 */
	@Select("select * from user where id=#{id}")
	public User queryUser(Integer id);
	
	/**
	 * 管理员登录方法
	 * @param uname
	 * @param upass
	 * @return
	 */
	public Guser glogin(String uname, String upass);
	
	/**
	 * 管理员管理普通用户
	 */
	public List<User> gchaxun6(PageVo pageVo);
	
	public PageVo gchaxun7(PageVo pageVo);
}
