package cn.baisee.service;

import cn.baisee.entity.Gpaper;

/**
 * ҵ���߼���
 * @author Administrator
 *
 */
public interface IPostService {
/**
 * ����Ա��������
 */
	public Integer post(Gpaper gpaper);
	/**
	 * ɾ������Ա����
	 * @param g_id
	 * @return
	 */
	public Integer delete_gpost(Integer g_id);
}
