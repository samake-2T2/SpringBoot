package com.simple.basic.memo;

import java.util.List;

import com.simple.basic.command.MemoVO;

public interface MemoService {
	public String getTime(); // 예제 코드
	
	public int regist(MemoVO vo); // 글 작성
	
	public List<MemoVO> getList();
}
