package com.dnjh.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.ex.jpa.domain.Student;
import com.dnjh.spring.ex.jpa.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	// C, U, D
	@GetMapping("/jpa/student/create")
	@ResponseBody
	public Student createStudent()
	{
		Student student = studentService.addStudent("HongGilDong", "010-1234-9876", "Hong@gmail.com", "프로그래머");
		// HongGilDong, 010-1234-9876, HongHong@gmail.com, 프로그래머
		
		return student;
	}
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest()
	{
//		Student student = new Student(10, "홍길동12", "010-1111-2222", "HongHong@gmail.com", "프로그래머", null, null);
//		student.setPhoneNumber("010-1234-9876");
		
		// @Builder(Builder 어노테이션) 사용으로 객체 생성
		// 순서 상관없음
		Student student = Student.builder()
				.name("HongGilDong")
				.phoneNumber("010-1234-9876")
				.dreamJob("프로그래머")
				.email("HongHong@gmail.com")
				.build();
		
		return student;
	}
}
