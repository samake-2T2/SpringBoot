package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.ProductUploadVO;
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
		int total = topicService.getTotalMe(cri);
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

		return "redirect:/topic/topicListAll"; // 등록이후 목록화면으로 감
	}

	// 상세보기
	@GetMapping("/topicDetail")
	public String topicDetail(@RequestParam("topic_no") int topic_no,
			Model model) {

		//데이터 저장
		TopicVO topicVO = topicService.getDetail(topic_no);
		model.addAttribute("topicVO", topicVO);

		return "topic/topicDetail";
	}

	// 수정화면
	@GetMapping("/topicModify")
	public String topicModify(@RequestParam("topic_no") int topic_no,
			Model model) {

		TopicVO topicVO = topicService.getDetail(topic_no);
		model.addAttribute("topicVO", topicVO);

		return "topic/topicModify";
	}

	// 수정폼
	@PostMapping("/topicUpdate")
	public String topicUpdate(TopicVO vo, RedirectAttributes RA) {

		int result = topicService.update(vo);

		if(result == 1 ) {
			RA.addFlashAttribute("msg", "수정되었습니다");
		} else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다. 관리자에게 문의하세요");
		}


		return "redirect:/topic/topicListMe";

	}

	// 삭제폼
	@GetMapping("/topicDelete")
	public String topicDelete(@RequestParam("topic_no") int topic_no,
			RedirectAttributes RA) {

		int result = topicService.delete(topic_no);

		if(result == 1) {
			RA.addFlashAttribute("msg", "상품이 삭제되었습니다");
		} else {
			RA.addFlashAttribute("msg", "삭제에 실패했습니다");
		}

		return "redirect:/topic/topicListMe";
	}

}
