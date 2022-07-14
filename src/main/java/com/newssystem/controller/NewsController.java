package com.newssystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

	@GetMapping("/")
//	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(Model modelo) {
		return "index";
	}

}
