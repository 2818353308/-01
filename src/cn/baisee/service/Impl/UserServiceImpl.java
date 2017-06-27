package cn.baisee.service.Impl;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Guser;
import cn.baisee.entity.User;
import cn.baisee.mapper.IUserMapper;
import cn.baisee.service.IUserService;
import cn.baisee.utils.StringUtils;
import cn.baisee.vo.PageVo;

@Service
public class UserServiceImpl implements IUserService {

	@Resource(name="IUserMapper")
	IUserMapper userMapper;
	
	
	/**
	 * �û���¼
	 */
	@Override
	public User login(User user) {
		//upass����md5����
		user.setUpass(StringUtils.encodeMd5(user.getUpass()));
		return userMapper.login(user);
	}
	
	/**
	 * ע��
	 */
	@Override
	public void saveRegister(User user) {
		//upass����md5����
		user.setUpass(StringUtils.encodeMd5(user.getUpass()));
		userMapper.saveUser(user);
	}


	@Override
	public User queryUserByUserName(String uname) {
		return userMapper.queryUserByName(uname);
	}
	

	/**
	 * �޸�����
	 */
	@Override
	public Integer modify_pass(String xupass, int id) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("xupass", StringUtils.encodeMd5(xupass));
		map.put("id", id);
		return userMapper.modify_pass(map);
	}
	
	@Override
	public User queryUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.queryUser(id);
	}
	
	/**
	 * ����T���
	 * @param uname
	 * @param upass
	 * @return
	 */
	@Override
	public Guser glogin(String uname, String upass) {
		
		return userMapper.glogin(new Guser(uname, upass));
	}
	
	
	@Override
	public List<User> gchaxun6(PageVo pageVo) {
		List<User> list = userMapper.gchaxunuser(pageVo);
		return list;
	}

	@Override
	public PageVo gchaxun7(PageVo pageVo) {
		List<User> list =userMapper.gchaxunuser(pageVo);
		pageVo.setResult3(list);
		Integer totalCount=userMapper.gchaxuntiaoshuuser(pageVo);
		//��������
		pageVo.setTotalCount(totalCount);
		return pageVo;
	}

	


}
