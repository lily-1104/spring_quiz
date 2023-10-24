package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
									// JpaRepository : Spring Data JPA
		
	
	
	// save(엔티티 객체) - id가 없으면 insert, id가 있으면 update
	
	// findById - 조회
	
	// delete
	
	

}
