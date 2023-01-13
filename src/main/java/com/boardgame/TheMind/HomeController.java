package com.boardgame.TheMind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home () {
		return "index";
	}
	
	@GetMapping("/roomList")
	public String roomList () {
		return "roomList";
	}
}
