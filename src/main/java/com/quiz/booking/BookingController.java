package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	
	@Autowired
	private BookingBO bookingBO;
	
	
	
	// 예약 목록 보기 화면
	// URL : http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String reservationListView(Model model) {
			
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
			
		return "booking/bookingList";
		
	}
	
	
	// 예약 삭제 기능 - AJAX 요청 (@ResponseBody 무조건)
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db insert
		bookingBO.deleteBookingById(id);
		
		// {"code":200, "result":"success"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result;
		
	}
	
	
	
	// 예약하기 화면
	// URL : http://localhost:8080/booking/add-booking-view
	@GetMapping("/add-booking-view")
	public String addBookingView() {
		
		return "booking/addBooking";
		
	}
	
	
	
	// 예약 추가
	@ResponseBody
	@PostMapping("/add-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("name") String date,
			@RequestParam("name") int day,
			@RequestParam("name") int headCount,
			@RequestParam("name") String phoneNumber) {
		
		
		// DB insert
		bookingBO.addBooking(name, date, day, headCount, phoneNumber);
		
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result;		// JSON String
		
	}
	
	
	
	// 예약 확인 화면
	// URL : http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingCheck();
		model.addAttribute("bookingList", bookingList);
		
		return "booking/checkBooking";
		
	}
	
	
	
	// 예약 조회 기능 - AJAX 요청
	@ResponseBody	// Model 사용 불가 (view로 가지 않아서 X, jsp 연결할 때만 사용 가능)
	@PostMapping("/search-booking")
	public Map<String, Object> searchBooking(	// JSON으로 내려서 Map 사용, 값이 여러가지로 내려가서 Object
			@RequestParam("name") String name,
			@RequestParam("name") String phoneNumber) {
		
		// DB select
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		
		
		// 응답값
		// {"code":400, "error_message":"데이터가 존재하지 않습니다"}	=> null 일 때
		// {"code":200, "result":{"id:1, "name":...}}
		Map<String, Object> result = new HashMap<>();
		
		if (booking == null) {
			
			result.put("code", 400);
			result.put("error_message", "데이터가 존재하지 않습니다");
			
		} else {
			
			result.put("code", 200);
			result.put("result", booking);
		}
		
		return result;
		
	}
	
	
}
