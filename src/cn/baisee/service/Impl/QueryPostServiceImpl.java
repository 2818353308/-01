package cn.baisee.service.Impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.baisee.entity.Gpaper;
import cn.baisee.mapper.IQueryPostMapper;
import cn.baisee.service.IQueryPostService;
import cn.baisee.vo.PageVo;

@Service
public class QueryPostServiceImpl implements IQueryPostService{
	
	@Resource(name = "IQueryPostMapper")
	private IQueryPostMapper queryPostMapper;
	
	
	@Override
	public List<Gpaper> gchaxun(PageVo pageVo) {
		List<Gpaper> list = queryPostMapper.gchaxun(pageVo);
		return list;
	}

	@Override
	public PageVo gchaxun2(PageVo pageVo) {
		if(pageVo!=null&&pageVo.getCurrentPage()==null){
			pageVo.setCurrentPage(1);
		}
		
		List<Gpaper> list = queryPostMapper.gchaxun(pageVo);
		pageVo.setResult3(list);
		
		Integer totalCount=queryPostMapper.gchaxuntiaoshu(pageVo);
		//共多少条
		pageVo.setTotalCount(totalCount);
		return pageVo;
	}

}
