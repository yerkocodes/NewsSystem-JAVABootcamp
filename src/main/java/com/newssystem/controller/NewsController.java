package com.newssystem.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
	
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

	@GetMapping("/")
//	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(Model modelo) {

		String pathNewsFile = "src/main/resources/static/news.txt";
		ArrayList<String> data = new ArrayList<>();
		
		try {
			
			FileReader fileReader = new FileReader(pathNewsFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = bufferedReader.readLine();
			
			while(line != null) {
				data.add(line);
				logger.info("A line has been read from the file");
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			fileReader.close();
			
			String[] news1 = data.get(0).split("@@");
			String[] news2 = data.get(1).split("@@");
			String[] news3 = data.get(2).split("@@");
			String[] news4 = data.get(3).split("@@");
			String[] news5 = data.get(4).split("@@");
			
			modelo.addAttribute("news1", news1);
			modelo.addAttribute("news2", news2);
			modelo.addAttribute("news3", news3);
			modelo.addAttribute("news4", news4);
			modelo.addAttribute("news5", news5);
			
		} catch (Exception e) {
			logger.error("An error ocurred while executing the home() method of the NewsController class - " + e);
		}

		return "index";
	}
	
//	MODELANDVIEW EXAMPLE
//	@GetMapping("/")
//	@RequestMapping(method = RequestMethod.GET, value = "/")
//	public ModelAndView home() {
//		ModelAndView modelAndView = new ModelAndView("index");
//		modelAndView.setViewName("index");
//		modelAndView.addObject(AttributeName, Object); // request.setAttribute
//		
//		return modelAndView;
//	}

}
