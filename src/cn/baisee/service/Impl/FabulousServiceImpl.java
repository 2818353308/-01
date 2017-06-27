package cn.baisee.service.Impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;







import org.springframework.stereotype.Service;

import cn.baisee.entity.Fabulous;
import cn.baisee.mapper.IFabulousMapper;
import cn.baisee.service.IFabulousService;

@Service
public class FabulousServiceImpl implements IFabulousService {

	@Resource(name="IFabulousMapper")
	IFabulousMapper fabulousMapper;

	@Override
	public Fabulous chazan(int user_id,int p_id) {
		Fabulous fabulous=new Fabulous();
		fabulous.setUser_id(user_id);
		fabulous.setP_id(p_id);
		Fabulous fabulous2=fabulousMapper.chazan(fabulous);
		
		/*JSONArray array=new JSONArray();
		array.add(fabulous2);*/
		
		return fabulous2;
	}

	@Override
	public List<Integer> queryut(Integer uid) {
		return fabulousMapper.queryut(uid);
	}

	@Override
	public Integer save(Integer user_id, Integer p_id) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("p_id", p_id);
		return fabulousMapper.save(map);
	}

	@Override
	public Integer querytotal(Integer p_id) {
		return fabulousMapper.querytotal(p_id);
	}

	
	
	
	
}
