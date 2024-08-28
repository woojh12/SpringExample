package com.dnjh.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.ex.jpa.domain.Student;
import com.dnjh.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	// C, U, D
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent()
	{
		Student student = studentService.addStudent("HongGilDong", "010-1234-9876", "Hong@gmail.com", "프로그래머");
		// HongGilDong, 010-1234-9876, HongHong@gmail.com, 프로그래머
		
		return student;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent()
	{
		// id가 3인 학생정보의 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent()
	{
		// id가 3인 학생정보 삭제
		studentService.deleteStudent(2);
		
		return "삭제!";
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
