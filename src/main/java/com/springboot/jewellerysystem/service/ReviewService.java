package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Review;
import java.util.List;

public interface ReviewService { 

  List<Review> getAllReview();

Review loadReviewById(Integer id );

Review createOrUpdateReview(Review review);

void removeReview(Integer id);

} 
