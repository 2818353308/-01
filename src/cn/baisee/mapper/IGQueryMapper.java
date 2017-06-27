package cn.baisee.mapper;

import java.util.List;

import cn.baisee.entity.Guser;
import cn.baisee.vo.PageVo;

public interface IGQueryMapper {
	public List<Guser> gchaxun1(PageVo pageVo);
	
	
	public Integer gchaxuntiaoshu1(PageVo pageVo);
}
