package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootsample.dao.shop.CartRepository;
import bootsample.model.shop.Cart;

@Service
@Transactional
public class CartService {
	
	private final CartRepository cartRepository;
	
	public CartService(CartRepository cartRepository){
		this.cartRepository = cartRepository;
	}
	
	
	public List<Cart> findAll(){
		List<Cart> carts = new ArrayList<>();

		for (Cart cart : cartRepository.findAll()) {
			carts.add(cart);
		}
		return carts;
	}
	

	public void save(Cart cart){
		cartRepository.save(cart);
	}
	
	public Cart findCart(int id){
		return cartRepository.findOne(id);
	}
	
	public void delete(int id){
		
		cartRepository.delete(id);
	}

}
