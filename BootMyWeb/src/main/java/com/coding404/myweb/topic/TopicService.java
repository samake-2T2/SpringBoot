package com.coding404.myweb.topic;

import java.util.ArrayList;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;

public interface TopicService {

	public int regist(TopicVO vo); // 등록

	public ArrayList<TopicVO> getListAll(Criteria cri); // 목록조회
	
	public ArrayList<TopicVO> getListMe(Criteria cri); // 목록조회

	public int getTotal(Criteria cri); // 전체게시글 수

}
