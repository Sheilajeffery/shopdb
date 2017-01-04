package bootsample.dao.shop;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.shop.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

	
	
}