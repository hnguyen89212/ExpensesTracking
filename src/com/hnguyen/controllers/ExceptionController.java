package com.hnguyen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exceptions")
public class ExceptionController {

	private String viewDir = "exception/";

	@RequestMapping("/generic")
	public String getGenericException() {
		return this.viewDir + "generic_exception";
	}

}
