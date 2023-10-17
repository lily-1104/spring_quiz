package com.quiz.lesson06.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Repository
public interface BookmarkMapper {
	
	
	// 즐겨찾기 추가
	public void insertBookmark(
			@Param("title") String title, 
			@Param("domain") String domain);
	
	
	
	// 1-2. 결과 페이지 이동
	public List<Bookmark> selectBookmarkList();
	
	
}
