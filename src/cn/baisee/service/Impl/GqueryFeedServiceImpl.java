package cn.baisee.service.Impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.baisee.entity.Feedback;
import cn.baisee.mapper.IGqueryFeedMapper;
import cn.baisee.service.IGqueryFeedService;
import cn.baisee.vo.PageVo;

@Service
public class GqueryFeedServiceImpl implements IGqueryFeedService{
	
	@Resource(name = "IGqueryFeedMapper")
	private  IGqueryFeedMapper igqueryFeedMapper;
	
	@Override
	public List<Feedback> gchaxun4(PageVo pageVo) {
		List<Feedback> list = igqueryFeedMapper.gchaxunfeed(pageVo);
		return list;
	}

	@Override
	public PageVo gchaxun5(PageVo pageVo) {
		List<Feedback> list = igqueryFeedMapper.gchaxunfeed(pageVo);
		pageVo.setResult3(list);
		Integer totalCount=igqueryFeedMapper.gchaxuntiaoshufeed(pageVo);
		//共多少条
		pageVo.setTotalCount(totalCount);
		return pageVo;
	}

}
