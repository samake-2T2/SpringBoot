package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.ValidVO;

@Controller
@RequestMapping("valid")
public class ValidController {

	// 화면처리
	@RequestMapping("/view")
	public void view() {
		
	}
	
	// 폼처리
	@PostMapping("/viewForm") // @RequestMapping post의 줄임말
	public String viewForm(@Valid  ValidVO vo, Errors errors, Model model) {
		
		if(errors.hasErrors()) { // 유효성 검사에 실패한 결과가 있을경우 true
			
			// System.out.println("유효성 검사 실패");
			
			// 1. 유효성 검사에 실패한 필드목록 확인
			List<FieldError> list = errors.getFieldErrors();
			
			// 2. 반복문 회전
			for(FieldError err : list) {
				System.out.println(err.getField()); // 유효성 검사에 실패한 변수명확인
				System.out.println(err.getDefaultMessage()); // 유효성 검사에 실패한 변수의 에러 메세지
				System.out.println(err.isBindingFailure()); // 유효성 검사에 바인딩이 안된 결과
				
				if(err.isBindingFailure()) { // 유효성 검사는 성공했으나, 자바측에서 에러가 난 경우 (ex: Integer가 문자로 들어올때)
					model.addAttribute("valid_" + err.getField(), "숫자로 입력하세요"); // 메시지 값을 직접 지정
					
				} else { // 유효성 검사가 실패한 경우
					// 모델에 메시지를 담음
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage()); // 변수의 에러메시지를 지정
					
				}
			} // end
			
			// 화면에 입력데이터를 유지하기 위해 model에 저장
			model.addAttribute("vo", vo);
			return "valid/view"; // 원래 화면으로
			
		} // if
		
		return "redirect:/valid/result"; // 결과화면으로 리다이렉트
	}
	
	// 결과화면
	@GetMapping("result")
	public void result() {
		
	}
}
