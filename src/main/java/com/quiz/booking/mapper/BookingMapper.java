package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
public interface BookingMapper {
	
	
	// 예약 목록 보기 화면
	public List<Booking> selectBookingList();
	
	
	
	// 예약 삭제 기능
	public void deleteBookingById(int id);
	
	
	
	// 예약 추가
	public void insertBooking(
			@Param("name") String name, 
			@Param("date") String date, 
			@Param("day") int day, 
			@Param("headCount") int headCount, 
			@Param("phoneNumber") String phoneNumber);
	
	
	
	// 예약 확인 화면
	public List<Booking> selectBookingCheck();
	
	
	
	// 예약 조회 기능
	public List<Booking> selectBookingByNamePhoneNumber(	// 예악건이 여러 개일 수도 있으니까 List<Booking>으로 전체 예약건 다 불러오고 BO에서 거름
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
	
}
