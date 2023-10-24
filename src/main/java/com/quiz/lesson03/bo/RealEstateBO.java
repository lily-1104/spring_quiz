package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	
	// 1-1. id 로 select 하기
	// input : id (정수) / output : RealEstate
	public RealEstate getRealEstateById(int id) {
		
		return realEstateMapper.selectRealEstateById(id);
	}
	
	
	
	// 1-2. 월세 조건 select
	// input : rentPrice / output : List<RealEstate>
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		
		// return null;
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
		
	}
	
	
	
	// 1-3. 복합조건 select
	// input : area, price / output : List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
		
	}
	
	
	
	// 2-1. 객체로 insert 하기
	// input : RealEstate / output : 성공된 행의 개수
	public int addRealEstate(RealEstate realEstate) {
		
		return realEstateMapper.insertRealEstate(realEstate);
		
	}
	
	
	
	// 2-2. field 로 insert 하기
	public int addRealEstateAsField(
			int realtorId, String address, 
			int area, String type, 
			int price, Integer rentPrice) {		// rentPrice는 null이 가능해서 Integer 사용 
		
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
		
	}
	
	
	
	// 3-1. update
	// input : id, price, type / output : 성공된 행의 개수
	public int updateRealEstateById(int id, int price, String type) {
		
		return realEstateMapper.updateRealEstateById(id, price, type);
		
	}
	
	
	
	// 4-1. delete
	// input : id / output : 성공된 행의 개수
	public int deleteRealEstateById(int id) {
		
		return realEstateMapper.deleteRealEstateById(id);
		
	}
	

}
