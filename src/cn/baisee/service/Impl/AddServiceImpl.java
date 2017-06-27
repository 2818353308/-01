package cn.baisee.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Guser;
import cn.baisee.mapper.IGaddMapper;
import cn.baisee.service.IGaddService;

@Service
public class AddServiceImpl implements IGaddService{
	/**
	 * ��������Ա
	 */
	@Resource(name = "IGaddMapper")
	private IGaddMapper addMapper;
	
	@Override
	public Integer gadd(Guser guser) {
		return addMapper.gadd(guser);
	}



}
