package cn.baisee.service;

import java.util.List;

import cn.baisee.entity.Gpaper;
import cn.baisee.vo.PageVo;

public interface IQueryPostService {
	public List<Gpaper> gchaxun(PageVo pageVo);
	
	public PageVo gchaxun2(PageVo pageVo);
}
