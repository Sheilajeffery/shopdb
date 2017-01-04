package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootsample.dao.shop.Cart_detailRepository;
import bootsample.model.customers.Customer;
import bootsample.model.shop.Cart_detail;
import bootsample.model.shop.PurchaseDetail;


@Service
@Transactional
public class Cart_detailService {

	private final Cart_detailRepository cart_detailRepository;
	
	public Cart_detailService(Cart_detailRepository cart_detailRepository){
		this.cart_detailRepository = cart_detailRepository;
	}
	
	public List<Cart_detail> findAll(){
		List<Cart_detail> cart_details = new ArrayList<>();

		for (Cart_detail cart_detail : cart_detailRepository.findAll()) {
			cart_details.add(cart_detail);
		}
		return cart_details;
	}
	
	
	public void save(Cart_detail cart_detail){
		cart_detailRepository.save(cart_detail);
	}
	
	public Cart_detail findCart_detail(int id){
		return cart_detailRepository.findOne(id);
	}
	
	public void delete(int id){
		
		cart_detailRepository.delete(id);
	}

	
	
}
