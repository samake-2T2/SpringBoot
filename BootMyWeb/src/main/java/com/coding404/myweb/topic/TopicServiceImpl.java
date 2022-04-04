package com.coding404.myweb.topic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicMapper topicMapper;
	
	@Override
	public int regist(TopicVO vo) {
		
		return topicMapper.regist(vo);
	}

	@Override
	public ArrayList<TopicVO> getListAll(Criteria cri) {
		
		return topicMapper.getListAll(cri);
	}

	@Override
	public ArrayList<TopicVO> getListMe(Criteria cri) {
		
		return null;
	}

	@Override
	public int getTotal(Criteria cri) {
		
		return topicMapper.getTotal(cri);
	}



	

}
