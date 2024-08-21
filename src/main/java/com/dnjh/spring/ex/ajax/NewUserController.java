package com.dnjh.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dnjh.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	@Autowired
	private UserService userService;
	
	// 사용자 추가 API
	@PostMapping("/create")
	public Map<String, String> createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce)
	{
			int count = userService.addUser(name, birthday, email, introduce);
			
			// 성공, 실패
			// {"result":"success"}
			// {"result":"fail"}
			Map<String, String> resultMap = new HashMap<>();
			if(count == 1)
			{
				// 성공
				resultMap.put("result", "success");
			}
			else
			{
				// 실패
				resultMap.put("result", "fail");
			}
			
			return resultMap;
	}
	
	// 사용자 입력 View
	@GetMapping("/input")
	public String userInput()
	{
		return "ajax/userInput";
	}
}
