package cn.baisee.service.Impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Gpaper;
import cn.baisee.mapper.IPostMapper;
import cn.baisee.service.IPostService;

/**
 * 管理员 发帖方法
 * 
 * @author Administrator
 *
 */
@Service
public class PostServiceImpl implements IPostService {
	@Resource(name = "IPostMapper")
	private IPostMapper postMapper;

	@Override
	public Integer post(Gpaper gpaper) {
		gpaper.setG_time(new Date());
		return postMapper.post(gpaper);
	}

	@Override
	public Integer delete_gpost(Integer g_id) {
		return postMapper.delete_gpost(g_id);
	}

	

}
