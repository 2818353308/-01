package cn.baisee.mapper;

import java.util.List;

import cn.baisee.entity.Gpaper;
import cn.baisee.vo.PageVo;

public interface IQueryPostMapper {
	public List<Gpaper> gchaxun(PageVo pageVo);
	
	public Integer gchaxuntiaoshu(PageVo pageVo);
}
