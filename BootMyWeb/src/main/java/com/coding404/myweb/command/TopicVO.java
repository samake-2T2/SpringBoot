package com.coding404.myweb.command;

import java.time.LocalDateTime;

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
public class TopicVO {
	
	private Integer topic_no; // PK - 자동증가값
	
	@NotBlank(message = "작성자는 필수 사항입니다.")
	private String topic_id;
	
	@NotBlank(message = "제목은 필수 사항입니다.")
	private String topic_title;
	
	@NotBlank(message = "내용은 필수 사항입니다.")
	private String topic_content;
	
	@NotBlank(message = "등록일은 필수 입니다.")
	@Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "yyyy년-MM월-dd일 형식입니다.")
	private String topic_regdate; // 오늘날짜 default
	
	
}
