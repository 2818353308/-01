package cn.baisee.service;


import java.util.List;

import cn.baisee.entity.Attention;

/**
 * ��ע
 * @author Administrator
 *
 */
public interface IAttentionService {

	/**
	 * ���ݵ�¼�û�ID��ѯ����ע��
	 * @param user_id
	 * @return
	 */
	public List<Attention> query_guanzhu(Integer user_id);
			
	/**
	 * ��ӹ�ע
	 * @param attention
	 * @return
	 */
	public Integer add_Attention(Attention attention);
	
	public Integer deleteAttention(Integer attention_id);
}
