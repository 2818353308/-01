package cn.baisee.service.Impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.baisee.entity.Attention;
import cn.baisee.mapper.IAttentionMapper;
import cn.baisee.service.IAttentionService;

@Service
public class AttentionServiceImpl implements IAttentionService {

	@Resource(name="IAttentionMapper")
	IAttentionMapper attentionMapper;

	@Override
	public List<Attention> query_guanzhu(Integer user_id) {
		return attentionMapper.query_guanzhu(user_id);
	}

	@Override
	public Integer add_Attention(Attention attention) {
		return attentionMapper.add_Attention(attention);
	}

	@Override
	public Integer deleteAttention(Integer attention_id) {
		return attentionMapper.deleteAttention(attention_id);
	}

	
	

}
