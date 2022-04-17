package com.coding404.myweb.topic;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;

@Mapper
public interface TopicMapper {

	public int regist(TopicVO vo); // 등록

	public ArrayList<TopicVO> getListAll(Criteria cri); // 목록조회

	public ArrayList<TopicVO> getListMe(Criteria cri); // 목록조회

	public int getTotal(Criteria cri); // 전체게시글 수
	
	public int getTotalMe(Criteria cri); // 내게시글 수

	public TopicVO getDetail(int topic_no); //상세
	
	public int update(TopicVO vo); // 수정
	
	public int delete(int topic_no); //삭제

}
