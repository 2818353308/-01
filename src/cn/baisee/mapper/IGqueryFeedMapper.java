package cn.baisee.mapper;

import java.util.List;

import cn.baisee.entity.Feedback;

import cn.baisee.vo.PageVo;

public interface IGqueryFeedMapper {
	
	public List<Feedback> gchaxunfeed(PageVo pageVo);
	
	
	public Integer gchaxuntiaoshufeed(PageVo pageVo);
}
