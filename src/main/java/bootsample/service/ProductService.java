package bootsample.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootsample.dao.shop.ProductRepository;
import bootsample.model.customers.Customer;
import bootsample.model.shop.Product;


@Transactional
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	
	public List<Product> findAll(){
		List<Product> products = new ArrayList<>();

		for (Product product : productRepository.findAll()) {
			products.add(product);
		}
		return products;
	}
	
	public void save(Product product){
		productRepository.save(product);
	}
	
	public Product findProduct(int id){
		return productRepository.findOne(id);
	}
	
	public void delete(int id){
		
		productRepository.delete(id);
	}
	

}
