package cn.baisee.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.baisee.entity.Guser;
import cn.baisee.entity.User;
import cn.baisee.vo.PageVo;

/**
 * �û�ҵ���߼���
 */
public interface IUserService {

	/**
	 * ��¼
	 */
	public User login(User user);
	
	public void saveRegister(User user);
	/*
	 * �����û�����ѯ�û�
	 */
	public User queryUserByUserName(String uname);
	
	/**
	 * �޸�����
	 */
	public Integer modify_pass(String xupass,int id);
	
	/**
	 * ����ID��ѯ�û�
	 * @return
	 */
	@Select("select * from user where id=#{id}")
	public User queryUser(Integer id);
	
	/**
	 * ����Ա��¼����
	 * @param uname
	 * @param upass
	 * @return
	 */
	public Guser glogin(String uname, String upass);
	
	/**
	 * ����Ա������ͨ�û�
	 */
	public List<User> gchaxun6(PageVo pageVo);
	
	public PageVo gchaxun7(PageVo pageVo);
}
