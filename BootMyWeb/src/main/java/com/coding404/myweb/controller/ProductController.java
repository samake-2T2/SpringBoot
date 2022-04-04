package com.coding404.myweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	// 등록화면
	@GetMapping("/productReg")
	public String productReg() {

		return "product/productReg";

	}

	// 목록화면
	@GetMapping("/productList")
	public String productList(Model model, Criteria cri) {
		
		System.out.println(cri.toString());
		
		// 1st
		//ArrayList<ProductVO> list = productService.getList();
		
		// 페이지
		ArrayList<ProductVO> list = productService.getList(cri);
		int total = productService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);
		
		// 데이터 저장
		model.addAttribute("list", list); // 데이터
		model.addAttribute("pageVO", pageVO); // 페이지네이션

		return "product/productList";

	}

	// 상세화면 - 화면에서는 prod_id를 넘긴다.
	@GetMapping("/productDetail")
	public String productDetail(@RequestParam("prod_id") int prod_id,
			Model model) {


		//		System.out.println(prod_id);
		// 데이터 저장
		ProductVO prodVO = productService.getDetail(prod_id);
		model.addAttribute("prodVO", prodVO);

		return "product/productDetail";

	}

	// 상품등록폼
	@PostMapping("/productForm")
	public String productForm(ProductVO vo,
							  RedirectAttributes RA) {

		//		System.out.println(vo.toString());
		int result = productService.regist(vo);

		if(result == 1) { // 1이면 성공, 0이면 실패
			RA.addFlashAttribute("msg", vo.getProd_name() + "이 정상등록되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "등록실패, 관리자에게 문의하세요");
		}

		return "redirect:/product/productList"; // 등록이후 목록화면으로 감
	}

	@PostMapping("/prodUpdate")
	public String prodUpdate(@Valid ProductVO vo,
							 Errors errors, // 임포트 주의
							 RedirectAttributes RA,
							 Model model) {

		//		System.out.println(vo.toString());

		if(errors.hasErrors()) { // 유효성 검사 실패시 true
			List<FieldError> list = errors.getFieldErrors(); // 유효성 검사 실패 목록확인
			
			for(FieldError err : list) {
//				System.out.println(err.getField()); // 유효성 검사 실패 멤버변수
//				System.out.println(err.getDefaultMessage()); // 유효성 검사 실패 메세지
				
				if(err.isBindingFailure()) { // 유효성 검사는 성공했으나, 자바측에서 에러가 난 경우 (ex: Integer가 문자로 들어올때)
					model.addAttribute("valid_" + err.getField(), "형식을 확인하세요"); // 메시지 값을 직접 지정
					
				} else { // 유효성 검사가 실패한 경우
					// 모델에 메시지를 담음
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage()); // 변수의 에러메시지를 지정
					
				}
			}
			// 화면에서는 prodVO이름으로 상세페이지에서 사용되고 있기 때문에, 같은 이름으로 보내서 처리합니다.
			model.addAttribute("prodVO", vo);
			
			return "product/productDetail"; // 유효성검사에 실패하면 다시 화면으로
		}

		// 업데이트
		int result = productService.update(vo);

		if(result == 1) { // 1이면 성공, 0이면 실패
			RA.addFlashAttribute("msg", vo.getProd_name() + "이 정상수정되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "수정실패, 관리자에게 문의하세요");
		}

		return "redirect:/product/productList"; // 목록화면(msg처리 js가 존재함)
	}
	
	@PostMapping("/prodDelete")
	public String prodDelete(@RequestParam("prod_id") int prod_id,
							 RedirectAttributes RA) {
		
//		System.out.println(prod_id);
		int result = productService.delete(prod_id);

		if(result == 1) { // 1이면 성공, 0이면 실패
			RA.addFlashAttribute("msg", "정상삭제되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "삭제실패, 관리자에게 문의하세요");
		}
		
		return "redirect:/product/productList";
	}

}
