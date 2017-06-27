package cn.baisee.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.baisee.entity.Guser;
import cn.baisee.entity.User;
import cn.baisee.vo.PageVo;

public interface IUserMapper {

	public User login(User user);
	
	public void saveUser(User user);
	
	public User queryUserByName(String uname);
	
	/**
	 * ����ID��ѯ�û�
	 * @return
	 */
	@Select("select * from user where id=#{id}")
	public User queryUser(Integer id);
	
	@Update("update user set upass=#{xupass} where id=#{id}")
	public Integer modify_pass(Map<String, Object> map);
		
	
	/**
	 * ����T��䛷���
	 * @param user
	 * @return
	 */
	public Guser glogin(Guser user);
	/**
	 * ����T��ѯ��ͨ�û�
	 */
	public List<User> gchaxunuser(PageVo pageVo);
	
	
	public Integer gchaxuntiaoshuuser(PageVo pageVo);
}
