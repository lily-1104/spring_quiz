package com.quiz.lesson04.mapper;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Realtor;

@Repository
public interface RealtorMapper {
	
	
	// URL : http://localhost:8080/lesson04/quiz02/add-realtor
	
	// INSERT
	public void insertRealtor(Realtor realtor);
	
	
	
	// SELECT
	public Realtor selectRealtorById(int id);
	

}
