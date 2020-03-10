package com.miervaldis42.climbingwebsite.controller;

// Imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String showTestPage() {
		return "test-page";
	}

}
