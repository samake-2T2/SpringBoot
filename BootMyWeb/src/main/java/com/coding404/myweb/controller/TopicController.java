package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.topic.TopicService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;

@Controller
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	@Qualifier("topicService")
	private TopicService topicService;

	// 등록화면
	@GetMapping("/topicReg")
	public String topicReg() {

		return "topic/topicReg";

	}

	// 목록화면
	@GetMapping("/topicListAll")
	public String topicListAll(Model model, Criteria cri) {

		System.out.println(cri.toString());

		// 1st
		//ArrayList<ProductVO> list = productService.getList();

		// 페이지
		ArrayList<TopicVO> list = topicService.getListAll(cri);
		int total = topicService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);

		// 데이터 저장
		model.addAttribute("list", list); // 데이터
		model.addAttribute("pageVO", pageVO); // 페이지네이션


		return "topic/topicListAll";
	}

	@GetMapping("/topicListMe")
	public String topicListMe(Model model, Criteria cri) {

		System.out.println(cri.toString());

		// 1st
		//ArrayList<ProductVO> list = productService.getList();

		// 페이지
		ArrayList<TopicVO> list = topicService.getListMe(cri);
		int total = topicService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);

		// 데이터 저장
		model.addAttribute("list", list); // 데이터
		model.addAttribute("pageVO", pageVO); // 페이지네이션


		return "topic/topicListMe";
	}

	// 상품등록폼
	@PostMapping("/topicForm")
	public String topicForm(TopicVO vo,
			RedirectAttributes RA) {

		//		System.out.println(vo.toString());
		int result = topicService.regist(vo);

		if(result == 1) { // 1이면 성공, 0이면 실패
			RA.addFlashAttribute("msg", "글이 정상등록되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "등록실패, 관리자에게 문의하세요");
		}

		return "redirect:/topic/TopicListAll"; // 등록이후 목록화면으로 감
	}

}
