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
 * ����Controller
 * @author Administrator
 */
@SessionAttributes({"shoucangPaper","myPaper","my_attention"})
@Controller
public class PaperController {
	
	@Resource(name="paperServiceImpl")
	private IPaperService paperService;
	
	//��ע
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
				map.put("post_type", "��Ϸ");
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
		 * ��ѯ�����е�����   
		 * Ȼ����������е�user_id��ѯ��������
		 * ��ѯ�������ӱ����������
		 */
		PageVo vo = paperService.chaxun2(pageVo);
		map.put("paper", vo);
		//��ת��AttentionController
		return "forward:query_attention.htmlx";
	}
	/**
	 * ����
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
			System.out.println("�ϴ�ͼƬ=="+post_image);
		}
	 	User loginUser = (User) request.getSession().getAttribute("loginUser");
	 	paper.setUser_id(String.valueOf(loginUser.getId()));
	 	paperService.addPaper(paper);
		return "redirect:/xianshi.htmlx";
	}
	
	/**
	 * ɾ������
	 * @param post_id����id
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
	 * �������Ĳ�ѯ����¼�û��ղص�����
	 */
	@RequestMapping("user/queryshoucang")
	public String queryshoucang(ModelMap map){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		List<Paper> shoucangPaper = paperService.queryshoucang(loginUser.getId());
		for(Paper item: shoucangPaper){
			System.out.println("�ղص�����"+item.getPost_content());
			System.out.println("�������ӵ���"+item.getUser());
		}
		map.put("shoucangPaper", shoucangPaper);
		//��ת������ķ����в�ѯ��½�û���������
		return "redirect:/user/mypaper.htmlx";
	}
	
	/**
	 * �������� ��¼�û���������
	 */
	@RequestMapping("user/mypaper")
	public String mypaper(ModelMap map){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		List<Paper> myPaper = paperService.mypaper(loginUser.getId());
		for(Paper item: myPaper){
			System.out.println("�ҷ��������"+item.getPost_content());
			System.out.println("�������ӵ���"+item.getUser());
		}
		map.put("myPaper", myPaper);
		//�ض�����ת��һ�·����в�ѯ����ע����
		return "redirect:/user/my_attention.htmlx";
		//return "redirect:/personal/personal.jsp";
	}
	
	/**
	 * ��ѯ��¼�û���ע����
	 * @return
	 */
	@RequestMapping("user/my_attention")
	public String myAttention(ModelMap map){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		List<Attention> attention_list = attentionService.query_guanzhu(loginUser.getId());
		map.put("my_attention", attention_list);
		//�ض�����ת����������
		return "redirect:/personal/personal.jsp";
	}
	
	/**
	 * ����Ա�鿴��������
	 */
	@RequestMapping("admin_paper")
	public String admin_paper(ModelMap map){
		PageVo vo = paperService.chaxun2(pageVo);
		map.put("admin_paper", vo);
		return "admin/adminquery_paper";
	}
	
	/**
	 * ����Աɾ����ͨ�û�������
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
		 * ��ѯ�����е�����   
		 * Ȼ����������е�user_id��ѯ��������
		 * ��ѯ�������ӱ����������
		 *//*
		
		List<Paper> list = paperService.chaxun(PageVo);
		
		List<Integer> attention_state = null;
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null){
			//����ѯ����ע���û�id�ŵ�attention_state
			attention_state =attentionService.query_guanli(loginUser.getId());
			if(attentionList.get(0).getBy_user_id()==p.getPost_id()){
				p.setguazhu(0);//0��ί��ע1һ�ǹ�ע
			}
		}
		//ѭ��������ѯ��������
		for(Paper p:list){
			if(attention_state!=null){
				//�ж�������ӵķ�����id���¼��id�Ƿ�һ�� һ������Ϊ�ѹ�ע
				for(Integer a:attention_state){
					System.out.println("����ע���û�"+a);
					if(a==Integer.valueOf(p.getUser_id())){
						p.setAttention_state(1);
					}
				}
			}
			//��ѯ�������ӱ���������� 
			Integer total=fabulousService.querytotal(p.getPost_id());
			p.setTotal(total);
			//��ѯ�����ӵ�����
			List<Comment> list_Comment=commentService.query_comment(p.getPost_id());
			//����ѯ�������۴�ŵ�p.setList_Comment
			p.setList_Comment(list_Comment);
			for(Comment item:list_Comment){
				System.out.println("������--------:"+item.getUser().getUname());
				System.out.println("��������:"+item.getC_content());
			}
			//System.out.println(p.getUser());
		}
		map.put("paper", list);
		return "forward:chazan.htmlx";
	}*/

}
