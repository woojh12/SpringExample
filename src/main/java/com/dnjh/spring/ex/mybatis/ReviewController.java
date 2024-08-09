package com.dnjh.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dnjh.spring.ex.mybatis.domain.Review;
import com.dnjh.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	// id가 5인 리뷰 정보를 json으로 Response 담는다.
	@RequestMapping("/")
	@ResponseBody
	public Review review(@RequestParam("id") int id)
	{
		// request Parameter
		// request.getParameter("id");
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
	// 리뷰 정보를 저장하는 페이지
	@RequestMapping("/create")
	@ResponseBody
	public String createReview()
	{
		// 4. 치즈피자, 홍길동, 4.5, 치즈피자 맛있다
		// int count = reviewService.addReview(4, "치즈피자", "홍길동", 4.5, "치즈피자 맛있음");
		
		// 2, 뿌링클, 홍낄동, 4.0, 역시 뿌링클은 진리 입니다.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("홍낄동");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다.");
		
		int count = reviewService.addReviewByObject(review);
		// 입력 개수 : 1
		return "입력 개수 : " + count;
	}
}
