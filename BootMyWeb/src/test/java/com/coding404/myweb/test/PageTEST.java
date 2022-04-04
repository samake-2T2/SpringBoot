package com.coding404.myweb.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.product.ProductMapper;
import com.coding404.myweb.topic.TopicMapper;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;

@SpringBootTest
public class PageTEST {
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	TopicMapper topicMapper;

	// 우클릭 -> run as -> junit test
//	@Test
//	public void test01() {
//		
//		for(int i = 1; i <= 100; i++) {
//			
//			ProductVO vo = ProductVO.builder().prod_enddate("2021-12-01")
//							   .prod_writer("admin")
//							   .prod_name("test" + i)
//							   .prod_price(10000 + i)
//							   .prod_count(10 * i)
//							   .prod_discount(i)
//							   .prod_purchase_yn("Y")
//							   .prod_content("test" + i)
//							   .prod_comment("test" + i)
//							   .build();
//			
//			productMapper.regist(vo);
//			
//		}
//		
//	}
	
//	@Test
//	public void test02() {
//		
//		Criteria cri = new Criteria(11, 10); // 조회하는 페이지번호, 데이터 개수
//		PageVO pageVO = new PageVO(cri, 151); // cri, 전체 게시글 수
//		
//		System.out.println(pageVO.toString());
//		
//	}
	
	@Test
	public void test03() {
		
		for(int i = 1; i <= 100; i++) {
			
			TopicVO vo = TopicVO.builder()
							   .topic_id("admin")
							   .topic_content("test" + i)
							   .topic_title("test" + i)
							   .topic_regdate("2022-04-03")
							   .build();
			
			topicMapper.regist(vo);
			
		}
		
	}
	
}
