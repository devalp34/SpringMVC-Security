package com.pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

	@GetMapping("/customLogin")
	public String loginprocess()
	{
		return "fancy-login";
	}
	
	@GetMapping("/falsecredential")
	public String errorHandling()
	{
		return "error-page";
	}
}
