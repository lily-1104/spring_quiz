package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	
	// 1. seller 추가
	// URL : http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		
		return "lesson04/addSeller";
		
	}
	
}
