package com.dnjh.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnjh.spring.ex.mybatis.domain.Review;
import com.dnjh.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 전달 받은 id와 일치하는 리뷰 정보 리턴 기능
	public Review getReview(int id)
	{
		// new_review 테이블에서 전달받은 id와 일치하는 행 조회
		Review review = reviewRepository.selectReview(id);
		
		return review;
	}
	
	// 리뷰에 저장할 값들을 전달 받고, 리뷰 저장
	// insert문은 수행시 정수 1을 반환함
	public int addReview(int scoreId
			, String menu
			, String userName
			, double point
			, String review)
	{
		int count = reviewRepository.insertReview(scoreId, menu, userName, point, review);
		
		return count;
	}
	
	// 리뷰에 저장할 값들을 객체로 전달 받고, 리뷰 저장 기능
	public int addReviewByObject(Review review)
	{
		int count = reviewRepository.insertReveiwByObject(review);
		
		return count;
	}
}
