package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoVO {

	private Integer mno;
	
	@NotBlank(message = "메모내용은 공백일 수 없습니다.")
	@Pattern(regexp = ".{5,}", message = "최소 5글자 이상 입력해주세요.")
	private String memo;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호는 000-0000-0000형식 입니다.")
	private String phone;
	
	@Pattern(regexp = "[0-9]{4}", message = "비밀번호는 4자리 숫자입니다.")
	private String pw;
	
	private String secret;
	
}
