package cn.baisee.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.baisee.entity.Comment;
import cn.baisee.entity.Paper;
import cn.baisee.entity.User;
import cn.baisee.service.ICommentService;
import cn.baisee.service.IPaperService;
import cn.baisee.vo.PageVo;
/**
 * 评论
 * @author Administrator
 */
@Controller
public class CommentController {
	@Resource(name = "commentServiceImpl")
	private ICommentService commentService;
	
	//帖子
	@Resource(name="paperServiceImpl")
	private IPaperService paperService;

	@RequestMapping("query_comment")
	public String query_comment(String post_id,ModelMap map,HttpServletRequest request){
		if(post_id==null){
			String post_id2=(String) request.getSession().getAttribute("post_id");
			if(post_id2!=null){
				post_id=post_id2;
			}else{
				post_id="1";
			}
		}
		PageVo pageVo=new PageVo();
		Map<String, Object> hmap=new HashMap<String, Object>();
		hmap.put("post_id", post_id);
		request.getSession().setAttribute("post_id", post_id);
		String post_type=(String) request.getSession().getAttribute("post_type");
		hmap.put("post_type", post_type);
		pageVo.setParams(hmap);
		List<Paper> list_paper=paperService.chaxun(pageVo);
		List<Comment> list = commentService.query_comment(Integer.valueOf(post_id));
		for(Paper item:list_paper){
			item.setList_Comment(list);
			System.out.println(item.getPost_content());
		}
		/*for(Comment item:list){
			System.out.println("评论人:"+item.getUser().getUname());
			System.out.println("评论内容:"+item.getC_content());
		}*/
		map.put("paper",list_paper );
		return "single";
	}
	
	
	
	/**
	 * 发表评论
	 * @param request
	 * @param c_content
	 * @param p_id
	 * @return
	 */
	@RequestMapping("user/add_comment")
	public String add_comment(HttpServletRequest request,String c_content,String p_id){
		System.out.println("评论内容=="+c_content);
		System.out.println("评论帖子的id=="+p_id);
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			return "login"; 
		}else if(c_content.equals("")||c_content==null){
			return "redirect:xianshi.htmlx";
		}
		commentService.add_comment(p_id, loginUser.getId(), c_content);
		return "redirect:/query_comment.htmlx";
	}
	/**
	 * 根据评论ID删除评论
	 * @param c_id
	 * @return
	 */
	@RequestMapping("user/delete_comment")
	public String delete(String c_id){
		System.out.println("删除评论ID为"+c_id);
		commentService.delete(c_id);
		return "redirect:/query_comment.htmlx";
	}
	
	
}
