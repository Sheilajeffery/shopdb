package bootsample.dao.shop;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.shop.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	
	
}
