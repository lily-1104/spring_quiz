package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	
	// 1-1. AJAX로 submit 대신 웹 요청하기
	// URL : http://localhost:8080/lesson06/quiz01/add-bookmark-view
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		
		return "lesson06/addBookmark";
		
	}
	
	
	// 즐겨찾기 추가 - AJAX가 하는 요청
	@PostMapping("/quiz01/add-bookmark")
	@ResponseBody
	public Map<String, Object> addBookmark(		// map<String, Object> : json으로 내리기위해서 사용
			@RequestParam("title") String title,
			@RequestParam("domain") String domain) {
		
		
		// db insert
		bookmarkBO.addBookmark(title, domain);
		
		
		// 응답값 (밑의 JSON 형태로 내릴거임
//			{
//				"code":200,
//				"result":"success"
//			}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result;	// JSON String
		
	}
	
	
	
	// 1-2. 결과 페이지 이동
	// URL : http://localhost:8080/lesson06/quiz01/bookmark-list-view
	@GetMapping("/quiz01/bookmark-list-view")
	public String bookmarkListView(Model model) {
		
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
		
	}
	

}
