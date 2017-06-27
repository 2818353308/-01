package cn.baisee.service.Impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Guser;
import cn.baisee.mapper.IGQueryMapper;
import cn.baisee.service.IGQueryService;
import cn.baisee.vo.PageVo;
@Service
public class GQueryServiceImpl implements IGQueryService{
	
	
	@Resource(name = "IGQueryMapper")
	private IGQueryMapper gqueryMapper;
	
	
	@Override
	public List<Guser> gchaxun1(PageVo pageVo) {
		List<Guser> list = gqueryMapper.gchaxun1(pageVo);
		return list;
	}
	@Override
	public PageVo gchaxun3(PageVo pageVo) {
		List<Guser> list = gqueryMapper.gchaxun1(pageVo);
		pageVo.setResult3(list);
		Integer totalCount=gqueryMapper.gchaxuntiaoshu1(pageVo);
		//共多少条
		pageVo.setTotalCount(totalCount);
		return pageVo;
	}

	

}
