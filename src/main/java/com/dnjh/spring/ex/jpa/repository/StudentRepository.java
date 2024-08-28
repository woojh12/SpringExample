package com.dnjh.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnjh.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	// 1행 Insert
	// id(PK:PrimaryKey)를 기반으로 하나의 행을 조회하는 기능
}
