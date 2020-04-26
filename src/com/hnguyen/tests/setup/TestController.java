package com.hnguyen.tests.setup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/home")
	public String test_home() {
		return "test/test_home";
	}
	
	@RequestMapping("/about")
	public String test_about() {
		return "test/test_about";
	}
	
	@RequestMapping("/contact")
	public String test_contact() {
		return "test/test_contact";
	}

}
