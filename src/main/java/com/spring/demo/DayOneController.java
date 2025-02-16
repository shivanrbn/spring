package com.spring.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Day1FileParser;

@RestController
public class DayOneController {

	@GetMapping("/day1")
	public String day1() {
		
		// src/main/resources/static/files/input_day_one.txt
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		Day1FileParser parser = new Day1FileParser("src/main/resources/static/files/input_day_one.txt");
		int TotalSum = parser.parseFile();
      
        // Condition holds true till
        // there is character in a string
		return String.format("The answer to the riddle is %d", TotalSum);
        
	}
	
}