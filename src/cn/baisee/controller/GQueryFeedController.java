package cn.baisee.controller;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.baisee.service.IGqueryFeedService;
import cn.baisee.vo.PageVo;

@Controller
public class GQueryFeedController {
	@Resource(name = "gqueryFeedServiceImpl")
	private IGqueryFeedService igqueryFeedService;

	@RequestMapping("queryfeed")
	public String query(ModelMap map) {
		PageVo pageVo = new PageVo();
		PageVo vo = igqueryFeedService.gchaxun5(pageVo);

		if (vo != null) {
			map.put("pageVo", vo);
			return "admin/gfeed";
		}
		return "admin/gfeed";
	}

}
