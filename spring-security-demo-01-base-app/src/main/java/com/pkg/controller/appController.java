package com.pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class appController {

	@GetMapping("/")
	public String first()
	{
		return "welcome";
	}
	
	@GetMapping("/student")
	public String second()
	{
		return "student";
	}
	
	@GetMapping("/teacher")
	public String third()
	{
		return "teacher";
	}
}
