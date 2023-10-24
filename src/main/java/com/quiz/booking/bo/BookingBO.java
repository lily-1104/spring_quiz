package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	
	@Autowired
	private BookingMapper bookingMapper;
	
	
	// 예약 목록 보기 화면
	// input : X / output : List<Booking>
	public List<Booking> getBookingList() {
		
		return bookingMapper.selectBookingList();
				
	}
	
	
	
	// 예약 삭제 기능
	// input : id / output : X
	public void deleteBookingById(int id) {	// 아무것도 리턴 안할거라서 void
		
		bookingMapper.deleteBookingById(id);
		
	}
	
	
	
	// 예약 추가
//		@RequestParam("name") String name,
//		@RequestParam("name") String date,
//		@RequestParam("name") int day,
//		@RequestParam("name") int headCount,
//		@RequestParam("name") String phoneNumber
	public void addBooking(String name, String date, int day, int headCount, String phoneNumber) {
		
		bookingMapper.insertBooking(name, date, day, headCount, phoneNumber);
		
	}
	
	
	
	// 예약 확인 화면
	public List<Booking> getBookingCheck() {
		
		return bookingMapper.selectBookingCheck();
		
	}
	
	
	
	// 예약 조회 기능
	// input : name, phoneNumber / output : Booking (null or Booking)
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		
		// Mapper (Interface, xml)에서는 DB에서 여러개를 다 불러오고 BO에서 마지막 한개만 걸러서 컨트롤러에 전달하면 그게 최신 예악건임
		// 컨트롤러가 리턴을 받을 때는 null이거나 부킹건이 있거나의 형태로 리턴 받음
		// 0 1 => 1 index가 최신 인덱스
		// bookingList가 비어있는지 확인 => 비어있으면 null로 리턴, 비어있지않으면 마지마 부킹을 리턴
		// 리스트가 비어있으면 null이 아닌 [](empty) 형태로 나옴
		if (bookingList.isEmpty()) {
			
			return null;	// null로 리턴
		}
		
		// 리스트가 비어있지 않으면 마지막 객체를 리턴
		return bookingList.get(bookingList.size() -1);		// 예약건 리턴
						// 리스트가 몇 개인지 몰라서 bookingList.size 에서 1을 뺀게 마지막 인덱스임
		
	}
	
	

}
