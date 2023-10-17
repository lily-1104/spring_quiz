package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	
	
	// 1-1. id 로 select 하기
	public RealEstate selectRealEstateById(int id);
	
	
	
	// 1-2. 월세 조건 select
	public List<RealEstate> selectRealEstateListByRentPrice(
			@Param("rentPrice1") int rentPrice);
	
	
	
	// 1-3. 복합조건 select
	public List<RealEstate> selectRealEstateListByAreaPrice(
			
			// @Param을 사용하면 하나의 map이 됨 (파라미터가 2개 이상일 때)
			@Param("area") int area11,
			@Param("price") int price22);
	
	
	
	// 2-1. 객체로 insert 하기
	// mybatis가 성공된 행의 개수를 채워서 리턴해줌
	public int insertRealEstate(RealEstate realEstate);
	
	
	
	// 2-2. field 로 insert 하기
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId11, 
			@Param("address") String address22, 
			@Param("area") int area33, 
			@Param("type") String type44, 
			@Param("price") int price55, 
			@Param("rentPrice") Integer rentPrice66);
	
	
	
	// 3-1. update
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("price") int price, 
			@Param("type") String type);
	
	
	
	// 4-1. delete
	public int deleteRealEstateById(int id);
	
	
}
