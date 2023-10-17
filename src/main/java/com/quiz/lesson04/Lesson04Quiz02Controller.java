package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	
	
	@Autowired
	private RealtorBO realtorBO;
	
	
	// 1. 공인중개사 추가
	// URL : http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		
		return "lesson04/addRealtor";
		
	}
	
	
	
	// URL : http://localhost:8080/lesson04/quiz02/add-realtor
	@PostMapping("/add-realtor")	// PostMapping 주소로 들어가면 405 에러남, 위의 GetMapping 주소로 들어가기
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		// INSERT
		realtorBO.addRealtor(realtor);
		
		// 받아온 id로 SELECT를 Model에 집어넣기
		Realtor newRealtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("realtor", newRealtor);
		
		
		// Response => jsp (view로 리턴)
		return "lesson04/afterAddRealtor";
		
	}
	

}
