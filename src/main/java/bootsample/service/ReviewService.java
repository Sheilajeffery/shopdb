package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootsample.dao.shop.ReviewRepository;
import bootsample.model.shop.Review;

@Service
@Transactional
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository){
		this.reviewRepository = reviewRepository;
	}

	public List<Review> findAll(){
		List<Review> reviews = new ArrayList<>();

		for (Review review : reviewRepository.findAll()) {
			reviews.add(review);
		}
		return reviews;
	}
	
	public void save(Review review){
		reviewRepository.save(review);
	}
	
	public Review findReview(int id){
		return reviewRepository.findOne(id);
	}
	
	public void delete(int id){
		
		reviewRepository.delete(id);
	}
	
	
	public List<Review> findAllProductReviews(int id){
		List<Review> reviews = new ArrayList<>();

		for (Review review : reviewRepository.findAll()) {
			if(review.getProductId() == id)
			reviews.add(review);
		}
		return reviews;
	}
	
	
}
