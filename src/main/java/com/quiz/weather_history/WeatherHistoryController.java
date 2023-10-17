package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	
	// 1. 날씨 정보 페이지
	// URL : http://localhost:8080/weather/history-view
	@GetMapping("/history-view")
	public String historyView(Model model) {
		
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();	// 여러개의 행이라서 List 사용, BO에서 가져와야함
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/history";
		
	}
	
	
	
	// 2. 날씨 입력 페이지
	// URL : http://localhost:8080/weather/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		
		return "weather_history/addWeather";
		
	}
	
	
	
	// 날씨 추가 로직
	@PostMapping("/add-weather")
	public String addWeather(
			
			// @RequestParam 아래 둘 중 하나 사용 가능, String type인 date를 Date type date로 교체
			// @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) { 
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		
		// DB Insert
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		
		// response 정의
		// 이미 있는 페이지로 redirect => history 페이지로 돌아감
		return "redirect:/weather/history-view";
		
	}
	
	
}
