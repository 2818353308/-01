package cn.baisee.service;

import java.util.List;



import cn.baisee.entity.Paper;
import cn.baisee.vo.PageVo;


/**
 * ����ҵ���߼���
 */
public interface IPaperService {

	public List<Paper> chaxun(PageVo pageVo);
	
	public Integer addPaper(Paper paper);
	
	public PageVo chaxun2(PageVo pageVo);
	/**
	 * ɾ������
	 * @param post_id����ID
	 * @return
	 */
	public Integer deletePaper(Integer post_id);
	
	
	/**
	 * �����Ĳ�ѯ����¼�û����ղ�����
	 */
	public List<Paper> queryshoucang(Integer user_id);
	
	/**
	 * �������� ��¼�û���������
	 * @param user_id
	 * @return
	 */
	public List<Paper> mypaper(Integer user_id);
	
}
