package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.ReviewDAO; 
import com.springboot.jewellerysystem.entity.Review; 
import com.springboot.jewellerysystem.service.ReviewService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService { 

@Autowired
 private ReviewDAO reviewDao;
 
 @Override 
    public List<Review> getAllReview() { 
        return reviewDao.findAll(); 
    } 

@Override 
  public Review loadReviewById(Integer id) {
 return reviewDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Review with ID " + id + " Not Found"));
 }

@Override 
    public Review createOrUpdateReview(Review review) {
return reviewDao.save(review);
   }

  @Override
 	    public void removeReview(Integer id) {
 	        reviewDao.deleteById(id);
 	    }

}
