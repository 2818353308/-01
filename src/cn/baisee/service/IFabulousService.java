package cn.baisee.service;

import java.util.List;

import cn.baisee.entity.Fabulous;

/**
 * ����ҵ���߼���
 */
public interface IFabulousService {

	public Fabulous chazan(int user_id,int p_id);

	public List<Integer> queryut(Integer uid);
	
	/**
	 * ����
	 * @param user_id
	 * @param p_id
	 * @return
	 */
	public Integer save(Integer user_id,Integer p_id);
	/**
	 * ��ѯ�����ӱ����������
	 */
	public Integer querytotal(Integer p_id);
}
