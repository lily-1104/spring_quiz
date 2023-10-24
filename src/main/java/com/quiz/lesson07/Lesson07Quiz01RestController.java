package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {
	
	
	@Autowired
	private CompanyBO companyBO;
	
	
	// 1-1 Create
	// URL : http://localhost:8080/lesson07/quiz01/save1
	@GetMapping("/save1")
	public CompanyEntity save1() {
		
		// JSON 으로 내려감
		return companyBO.addCompany("넥슨", "컨텐츠 게임", "대기업", 3585);
		
	}
	
	
	
	// 1-2 Create
	// URL : http://localhost:8080/lesson07/quiz01/save2
	@GetMapping("/save2")
	public CompanyEntity save2() {
		
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		
	}
	
	
	
	// 2 Update
	// URL : http://localhost:8080/lesson07/quiz01/update
	@GetMapping("/update")
	public CompanyEntity update() {
		
		// id : 12
		return companyBO.updateCompanyScaleHeadcountById(12, "중소기업", 34);
		
	}
	
	
	
	// 3 Delete
	// URL : http://localhost:8080/lesson07/quiz01/delete
	@GetMapping("/delete")
	public String delete() {
		
		// id : 12
		companyBO.deleteCompanyById(12);
		
		return "삭제 성공";
		
	}
	
	
}
