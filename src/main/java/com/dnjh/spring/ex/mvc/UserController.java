package com.dnjh.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dnjh.spring.ex.mvc.domain.User;
import com.dnjh.spring.ex.mvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	// RequestMapping 원래 형식
//	@RequestMapping(path="/mvc/user/info", method=RequestMethod.GET)
	
	// RequestMapping과 같은 기능, Get Method 방식으로 전달
	@GetMapping("/mvc/user/info")
	public String userInfo(Model model)
	{
		User user = userService.getLastUser();
		
		model.addAttribute("result", user);
		model.addAttribute("title", "회원정보");
		
		return "mvc/userInfo";
	}
}
