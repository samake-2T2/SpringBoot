package com.simple.basic.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVO;

@Service("memoService")
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	private MemoMapper memoMapper;
	
	@Override
	public String getTime() {
		
		return memoMapper.getTime();
	}

	@Override
	public int regist(MemoVO vo) {
		
		return memoMapper.regist(vo);
	}

	@Override
	public List<MemoVO> getList() {
		
		return memoMapper.getList();
	}

	

}
