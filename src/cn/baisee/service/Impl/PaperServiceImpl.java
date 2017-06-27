package cn.baisee.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Paper;
import cn.baisee.mapper.IPaperMapper;
import cn.baisee.service.IPaperService;
import cn.baisee.vo.PageVo;

@Service
public class PaperServiceImpl implements IPaperService {

	@Resource(name="IPaperMapper")
	IPaperMapper paperMapper;

	/**
	 * 查询所有的帖子
	 */
	@Override
	public List<Paper> chaxun(PageVo pageVo) {
		List<Paper> list = paperMapper.chaxun(pageVo);
		return list;
	}
	
	

	@Override
	public Integer addPaper(Paper paper) {
		
		paper.setPost_time(new Date());
		return paperMapper.addPaper(paper);
	}



	@Override
	public PageVo chaxun2(PageVo pageVo) {
		if(pageVo!=null&&pageVo.getCurrentPage()==null){
			pageVo.setCurrentPage(1);
		}
		List<Paper> list = paperMapper.chaxun(pageVo);
		pageVo.setResult(list);
		Integer totalCount=paperMapper.chaxuntiaoshu(pageVo);
		//共多少条
		pageVo.setTotalCount(totalCount);
		return pageVo;
	}



	@Override
	public Integer deletePaper(Integer post_id) {
		return paperMapper.deletePaper(post_id);
	}



	@Override
	public List<Paper> queryshoucang(Integer user_id) {
		return paperMapper.queryshoucang(user_id);
	}



	@Override
	public List<Paper> mypaper(Integer user_id) {
		return paperMapper.mypaper(user_id);
	}
	
	
	
}
