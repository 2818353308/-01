package cn.baisee.service;

import java.util.List;

import cn.baisee.entity.Shoucang;
public interface IShoucangService {

	/**
	 * ���ݵ�¼�û�id��ѯ���û����ղص�����id
	 * @param user_id
	 * @return
	 */
	public List<Shoucang> queryS(Integer user_id);
	/**
	 * ����ղ�
	 * @param shoucang
	 * @return
	 */
	public Integer add_shoucang(Shoucang shoucang);
	
	/**
	 * �����ղ�IDɾ��һ������Ϊȡ���ղ�
	 */
	public Integer delete_shoucang(Integer s_id);
			
}
