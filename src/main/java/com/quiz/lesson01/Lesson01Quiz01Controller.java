package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller		// Spring bean으로 등록
public class Lesson01Quiz01Controller {
	
	// 요청 URL : http://localhost:8080/lesson01/quiz01/1
	@RequestMapping("/1")
	@ResponseBody
	public String quiz01_1() {
		
		return "<h1>테스트 프로젝트 완성</h1>"
		+ "<h3>해당 프로젝트를 통해서 문제 풀이를 진행합니다</h3>";
				
	}
	
	
	
	// HttpMessageConverter와 Annotation 1
	
	// 요청 URL : http://localhost:8080/lesson01/quiz01/2
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> quiz01_2() {	// 값을 숫자로 내릴거라서 Integer 사용 (Object 써도 됨)
		
		Map<String, Integer> result = new HashMap<>();
		result.put("국어", 80);
		result.put("영어", 85);
		result.put("수학", 90);
		
		return result;
		
	}
	

}
