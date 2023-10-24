package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	
	@Autowired
	private CompanyRepository companyRepository;	// Repository 가져오면 JPA 사용
	
	
	// 1-1, 1-2 Create
	// input : 4개 파라미터 / output : 방금 insert 된 Entity
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		
		return companyRepository.save(
					CompanyEntity.builder()
					.name(name)
					.business(business)
					.scale(scale)
					.headcount(headcount)
					.build());
		
	}
	
	
	
	// 2 Update
	// input : 3개 파라미터 / output : CompanyEntity
	public CompanyEntity updateCompanyScaleHeadcountById(int id, String scale, int headcount) {
		
		CompanyEntity company = companyRepository.findById(id).orElse(null);	// findById : select를 하는 메소드 (내부적으로 가지고있음)
									// 없으면 null로 받고, 있으면 Entity로 받겠다
		
		if (company != null) {
			
			return companyRepository.save(
					company.toBuilder()	// toBuilder가 안뜨면 Entity 가서 @Builder(toBuilder = true)로 어노테이션 변경
					.scale(scale)
					.headcount(headcount)
					.build());
			
		}
		
		return null;
		
	}
	
	
	
	// 3 Delete
	// input : id / output : X (void)
	public void deleteCompanyById(int id) {
		
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);	// util로 임포트
		
		companyOptional.ifPresent(c -> companyRepository.delete(c));	// c는 company의 c
		
	}
	
	
}
