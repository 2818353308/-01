package cn.baisee.service.Impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Shoucang;
import cn.baisee.mapper.IShoucangMapper;
import cn.baisee.service.IShoucangService;

@Service
public class ShoucangServiceImpl implements IShoucangService {

	@Resource(name="IShoucangMapper")
	IShoucangMapper shoucangMapper;

	@Override
	public List<Shoucang> queryS(Integer user_id) {
		return shoucangMapper.queryS(user_id);
	}

	@Override
	public Integer add_shoucang(Shoucang shoucang) {
		return shoucangMapper.add_shoucang(shoucang);
	}

	@Override
	public Integer delete_shoucang(Integer s_id) {
		return shoucangMapper.delete_shoucang(s_id);
	}

	
	
	

}
