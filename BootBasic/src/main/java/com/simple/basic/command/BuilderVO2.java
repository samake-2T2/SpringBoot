package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // 빌더패턴을 사용가능
@ToString
public class BuilderVO2 {

	private String name;
	private int age;
	
}
