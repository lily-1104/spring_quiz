package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.Mapper.BookmarkMapper;
import com.quiz.lesson06.domain.Bookmark;

@Service
public class BookmarkBO {
	
	
	@Autowired 
	private BookmarkMapper bookmarkMapper;
	
	
	// 즐겨찾기 추가
	public void addBookmark(String title, String domain) {
		
		bookmarkMapper.insertBookmark(title, domain);
		
	}
	
	
	
	// 1-2. 결과 페이지 이동
	public List<Bookmark> getBookmarkList() {
		
		return bookmarkMapper.selectBookmarkList();
				
	}
	
	

}
