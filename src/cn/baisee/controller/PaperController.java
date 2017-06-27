package cn.baisee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import cn.baisee.entity.Attention;
import cn.baisee.entity.Paper;
import cn.baisee.entity.User;
import cn.baisee.service.IAttentionService;
import cn.baisee.service.IPaperService;
import cn.baisee.utils.UploadUtil;
import cn.baisee.vo.PageVo;
/**
 * 帖子Controller
 * @author Administrator
 */
@SessionAttributes({"shoucangPaper","myPaper","my_attention"})
@Controller
public class PaperController {
	
	@Resource(name="paperServiceImpl")
	private IPaperService paperService;
	
	//关注
	@Resource(name = "attentionServiceImpl")
	private IAttentionService attentionService;
	
	private Paper paper;
	private HttpServletRequest request;
	private PageVo pageVo;
	@ModelAttribute
	public void init(Paper paper,HttpServletRequest request,PageVo pageVo){
		if(pageVo.getParams()==null){
			String post_type=(String) request.getSession().getAttribute("post_type");
			if(post_type!=null){
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("post_type", post_type);
				pageVo.setParams(map);
			}else{
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("post_type", "游戏");
				pageVo.setParams(map);
			}
		}
		this.pageVo=pageVo;
		request.getSession().setAttribute("post_type", pageVo.getParams().get("post_type"));
		this.paper=paper;
		this.request=request;
	}
	
	@RequestMapping("xianshi")
	public String b(ModelMap map){
		/**
		 * 查询出所有的帖子   
		 * 然后根据帖子中的user_id查询出发帖人
		 * 查询出该帖子被点过多少赞
		 */
		PageVo vo = paperService.chaxun2(pageVo);
		map.put("paper", vo);
		//跳转到AttentionController
		return "forward:query_attention.htmlx";
	}
	/**
	 * 发帖
	 * @return
	 */
	@RequestMapping("user/addpaper")
	public String addPaper(@RequestParam(name="image",required=false) MultipartFile file){
		
		if(paper.getPost_content().equals("")||paper.getPost_content()==null){
	 		return "redirect:/xianshi.htmlx";
	 	}
		if(!file.getOriginalFilename().equals("")){
			String post_image = UploadUtil.uploadFile(request, "paperimage", file);
			paper.setPost_image(post_image);
			System.out.println("上传图片=="+post_image);
		}
	 	User loginUser = (User) request.getSession().getAttribute("loginUser");
	 	paper.setUser_id(String.valueOf(loginUser.getId()));
	 	paperService.addPaper(paper);
		return "redirect:/xianshi.htmlx";
	}
	
	/**
	 * 删除帖子
	 * @param post_id帖子id
	 * @return
	 */
	@RequestMapping("user/delete")
	public String delete(String post_id){
		if(post_id!=null){
			paperService.deletePaper(Integer.valueOf(post_id));
		}
		return "redirect:/xianshi.htmlx";
	}
	
	/**
	 * 个人中心查询出登录用户收藏的帖子
	 */
	@RequestMapping("user/queryshoucang")
	public String queryshoucang(ModelMap map){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		List<Paper> shoucangPaper = paperService.queryshoucang(loginUser.getId());
		for(Paper item: shoucangPaper){
			System.out.println("收藏的帖子"+item.getPost_content());
			System.out.println("发表帖子的人"+item.getUser());
		}
		map.put("shoucangPaper", shoucangPaper);
		//跳转到下面的方法中查询登陆用户发的帖子
		return "redirect:/user/mypaper.htmlx";
	}
	
	/**
	 * 个人中心 登录用户发的帖子
	 */
	@RequestMapping("user/mypaper")
	public String mypaper(ModelMap map){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		List<Paper> myPaper = paperService.mypaper(loginUser.getId());
		for(Paper item: myPaper){
			System.out.println("我发表的帖子"+item.getPost_content());
			System.out.println("发表帖子的人"+item.getUser());
		}
		map.put("myPaper", myPaper);
		//重定向跳转到一下方法中查询被关注的人
		return "redirect:/user/my_attention.htmlx";
		//return "redirect:/personal/personal.jsp";
	}
	
	/**
	 * 查询登录用户关注的人
	 * @return
	 */
	@RequestMapping("user/my_attention")
	public String myAttention(ModelMap map){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		List<Attention> attention_list = attentionService.query_guanzhu(loginUser.getId());
		map.put("my_attention", attention_list);
		//重定向跳转到个人中心
		return "redirect:/personal/personal.jsp";
	}
	
	/**
	 * 管理员查看所有帖子
	 */
	@RequestMapping("admin_paper")
	public String admin_paper(ModelMap map){
		PageVo vo = paperService.chaxun2(pageVo);
		map.put("admin_paper", vo);
		return "admin/adminquery_paper";
	}
	
	/**
	 * 管理员删除普通用户的帖子
	 */
	@RequestMapping("admin_deletePaper")
	public String admin_deletePaper(String post_id){
		if(post_id!=null){
			paperService.deletePaper(Integer.valueOf(post_id));
		}
		return "redirect:/admin_paper.htmlx";
	}
	
	
	
	
	/*@RequestMapping("xianshi2")
	public String a(ModelMap map){
		*//**
		 * 查询出所有的帖子   
		 * 然后根据帖子中的user_id查询出发帖人
		 * 查询出该帖子被点过多少赞
		 *//*
		
		List<Paper> list = paperService.chaxun(PageVo);
		
		List<Integer> attention_state = null;
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			//将查询出关注的用户id放到attention_state
			attention_state =attentionService.query_guanli(loginUser.getId());
			if(attentionList.get(0).getBy_user_id()==p.getPost_id()){
				p.setguazhu(0);//0市委关注1一是关注
			}
		}
		//循环出所查询出的帖子
		for(Paper p:list){
			if(attention_state!=null){
				//判断这个帖子的发帖人id与登录人id是否一致 一致则设为已关注
				for(Integer a:attention_state){
					System.out.println("被关注的用户"+a);
					if(a==Integer.valueOf(p.getUser_id())){
						p.setAttention_state(1);
					}
				}
			}
			//查询出该帖子被点过多少赞 
			Integer total=fabulousService.querytotal(p.getPost_id());
			p.setTotal(total);
			//查询该帖子的评论
			List<Comment> list_Comment=commentService.query_comment(p.getPost_id());
			//将查询到的评论存放到p.setList_Comment
			p.setList_Comment(list_Comment);
			for(Comment item:list_Comment){
				System.out.println("评论人--------:"+item.getUser().getUname());
				System.out.println("评论内容:"+item.getC_content());
			}
			//System.out.println(p.getUser());
		}
		map.put("paper", list);
		return "forward:chazan.htmlx";
	}*/

}
