package com.boardgame.TheMind;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/gameRoom/{roomNum}")
	public ModelAndView roomOpen (@PathVariable String roomNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("roomNum", roomNum);
		mv.setViewName("gameRoom");
		return mv;
	}
	
}
