package com.dnjh.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.ex.mvc.domain.User;
import com.dnjh.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	// Transaction : 여러 쿼리를 묶어서 동시에 수행하는 기능
	
	// 사용자 정보 저장 기능
	@PostMapping("/create")
	public String createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			, Model model)
	{
//		int count = userService.addUser(name, birthday, email, introduce);
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		userService.addUserByObject(user);
		
		// insert를 한 후에 바로 id값을 가져오는 기능 구현
		model.addAttribute("result", user);
//		return "redirect:/mvc/user/info";
		return "mvc/userInfo";
	}
	
	// 입력 화면 페이지
	@GetMapping("/input")
	public String userInput()
	{
		return "mvc/userInput";
	}
	
	// RequestMapping 원래 형식
//	@RequestMapping(path="/mvc/user/info", method=RequestMethod.GET)
	
	// RequestMapping과 같은 기능, Get Method 방식으로 전달
	@GetMapping("/info")
	public String userInfo(Model model)
	{
		User user = userService.getLastUser();
		
		model.addAttribute("result", user);
		model.addAttribute("title", "회원정보");
		
		return "mvc/userInfo";
	}
}
