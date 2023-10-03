package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		// @Controller + @ResponseBody
public class Lesson01Quiz02RestController {
	
	// HttpMessageConverter와 Annotation 2
	
	
	// 1. json 출력 (List, Map)
	
	// 요청 URL : http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/lesson01/quiz02/1")
	public List<Map<String, Object>> quiz02() {
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		list.add(movie);
		
		movie = new HashMap<>();	// 이 코드 대신 Map<String, Object> movie1 = new HashMap<>(); 라고 해도 됨 (movie가 겹치기 때문에 그것만 이름 바꿔주기)   
		movie.put("rate", 0);
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");	// movie 이름을 전체 다 바꾸고싶으면 Alt + Sht + R
		list.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 12);
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("title", "인셉션");
		list.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 19);
		movie.put("director", "윤종빈");
		movie.put("time", 133);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
		list.add(movie);
		
		return list;
		
	}
	
	
	
	// 2. json 출력 (List, Class)
	// 요청 URL : http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/lesson01/quiz02/2")
	public List<Board> quiz02_2() {		// <Board>는 클래스 이름
		
		// @ResponseBody + return String => HttpMessageConverter (스프링에 내장되어있는 클래스)
//			@ResponseBody와 String이 함께 사용이 되면 자동적으로 HttpMessageConverter 클래스가 동작 => 스프링이 html로 해석이 돼서 response body에 내려감
		
		// @ResponseBody + return 객체 (List, Map, 클래스) => HttpMessageConverter 동작 => jackson 라이브러리 동작 => JSON이 response body에 내려감 => 이걸 API라고 부름  
		
		List<Board> result = new ArrayList<>();
		
		Board board = new Board();	// 일반 자바 bean(객체)
		board.setTitle("안녕하세요 가입인사 드립니다");
		board.setUser("hagulu");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		result.add(board);
		
		board = new Board();
		board.setTitle("헐 대박");
		board.setUser("bada");
		board.setContent("오늘 목요일이었어... 금요일인줄");
		result.add(board);
		
		board = new Board();
		board.setTitle("오늘 데이트 한 이야기 해드릴게요");
		board.setUser("dulumary");
		board.setContent(".....");
		result.add(board);
		
		return result;
		
	}
	
	
	
	// 3. ResponseEntity
	// 요청 URL : http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/lesson01/quiz02/3")
	public ResponseEntity<Board> quiz02_3() {
		
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다");
		board.setUser("hagulu");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
}
