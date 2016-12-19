package bootsample.dao.shop;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.shop.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>{

}
