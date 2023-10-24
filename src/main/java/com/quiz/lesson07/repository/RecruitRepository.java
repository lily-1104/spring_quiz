package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	
	
	// 2-2 Parameter 조건 조회
	// JPQL => Entity 조회
	public List<RecruitEntity> findByCompanyId(int CompanyId);
	
	
	
	// 2-3 복합 조건 조회
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	
	
	// 2-4 복합 조건 조회
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	
	
	// 2-5 정렬 제한 조건
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	
	
	// 2-6 범위 조회
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int salaryStart, int salaryEnd);
	
	
	
	// 2-7 Native query 조회 => DB에 직접 조회
	@Query(value = "select * from `recruit` "	// "" 끝에 닫기 전에 한칸 띄는게 좋음
			+ "where `deadline` > :deadline "
			+ "and `salary` >= :salary "
			+ "and `type` = :type "
			+ "order by salary desc", nativeQuery = true)	// 비교할 때는 :deadline 사용, nativeQuery = true : DB 쿼리문을 켜겠다
	public List<RecruitEntity> findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline, 
			@Param("salary") int salary, 
			@Param("type") String type);
	
	
}
