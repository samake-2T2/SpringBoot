package com.coding404.myweb.command;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVO {
	// 1. 스프링부트 JPA라이브러리를 사용하면, 기본타입은 null을 가질 수 없기 떄문에 값이 맵핑이 안된다.
	//    그래서 wrapper형으로 반드시 선언한다.

	// 2. 유효성 검사에 필요한 멤버변수에 어노테이션 설정
	// - @NotNull : null을 허용하지 않는다. (String, Long 등등에 적용가능)
	// - @NotBlank : null, "", " "을 허용하지 않는다. (String에 적용)
	// - @NotEmpty : null, "" 허용하지 않는다.(String, Array등등에 적용가능)
	// - @Pattern : 정규표현 형식의 문자열로 정의 할 수 있다.(String에 적용가능)
	// - @Email : 이메일 형식만 허용
	
	private Integer prod_id; // PK - 자동증가값
	private LocalDateTime prod_regdate; // 오늘날짜 default

	@NotBlank(message = "판매종료일은 필수 입니다.")
	@Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "yyyy년-MM월-dd일 형식입니다.")
	private String prod_enddate;
	
	
	private String prod_category;
	
	@NotBlank(message = "작성자는 필수 사항입니다.")
	private String prod_writer;
	
	@NotBlank(message = "상품명은 필수 사항입니다.")
	private String prod_name; // 상품명
	
	@NotNull(message = "가격은 필수 입니다.")
	@Min(value = 0, message = "가격은 0원 이상입니다.") // 최소값 적용
	private Integer prod_price;
	
	@NotNull(message = "갯수는 필수 입니다.")
	@Min(value = 0, message = "갯수는 0개 이상입니다.") // 최소값 적용
	private Integer prod_count;
	
	@NotNull(message = "할인율은 필수 입니다.")
	@Min(value = 0, message = "할인율은 0% 이상입니다.") // 최소값 적용
	private Integer prod_discount;
	
	private String prod_purchase_yn;
	
	@NotBlank(message = "상품설명은 필수 입니다.")
	private String prod_content;
	
	private String prod_comment;

}
