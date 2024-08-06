package com.dnjh.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex02Controller {
	@RequestMapping("/lifecycle/ex02")
	public String thymeleafEx()
	{
		return "lifecycle/ex02";
	}
}
