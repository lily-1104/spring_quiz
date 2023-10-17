package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {
	
	
	@Autowired
	private RealtorMapper realtorMapper;
	
	
	// URL : http://localhost:8080/lesson04/quiz02/add-realtor
	
	// INSERT
	// input : Realtor 객체 / output : X
	public void addRealtor(Realtor realtor) {
		
		realtorMapper.insertRealtor(realtor);
		
	}
	
	
	
	// SELECT
	// input : realtor의 id / output : Realtor의 객체
	public Realtor getRealtorById(int id) {
		
		return realtorMapper.selectRealtorById(id);
		
	}
	

}
