package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootsample.dao.customers.CustomerRepository;
import bootsample.dao.shop.CartRepository;
import bootsample.dao.shop.Cart_detailRepository;
import bootsample.dao.shop.ProductRepository;
import bootsample.model.customers.Customer;
import bootsample.model.shop.*;

@Service
// @Transactional
public class PurchaseService {

	private final Cart_detailRepository cart_detailRepository;
	private final CartRepository cartRepository;
	private final CustomerRepository customerRepository;
	private final ProductRepository productRepository;

	public PurchaseService(Cart_detailRepository cart_detailRepository, CartRepository cartRepository,
			CustomerRepository customerRepository, ProductRepository productRepository) {
		this.cart_detailRepository = cart_detailRepository;
		this.cartRepository = cartRepository;
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
	}

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();

		for (Product product : productRepository.findAll()) {
			products.add(product);
		}
		return products;
	}

	public List<Cart> findAllCarts() {
		List<Cart> carts = new ArrayList<>();

		for (Cart cart : cartRepository.findAll()) {
			carts.add(cart);
		}
		return carts;
	}

	public List<PurchaseDetail> findByCartId(int id) {
		List<Cart_detail> cart_details = new ArrayList<>();
		List<PurchaseDetail> purchase_detail = new ArrayList<>();
		int cartId;
		String product;
		int nr_of;
		float price;
		PurchaseDetail pd;

		for (Cart_detail cart_detail : cart_detailRepository.findAll()) 
			if (cart_detail.getCartId() == id)
				cart_details.add(cart_detail);
		

		for (Cart_detail cd : cart_details) {
			cartId = cd.getCartId();
			product = productRepository.findOne(cd.getProductId()).getName();
			nr_of = cd.getNumber_of_products();
			price = nr_of * productRepository.findOne(cd.getProductId()).getPrice();

			 pd= new PurchaseDetail(cartId, product, nr_of, price);
			purchase_detail.add(pd);
		}
	return purchase_detail;

	}
	public float totalPrice(int id) {

		List<Cart_detail> cart_details = new ArrayList<>();
		List<PurchaseDetail> purchase_detail = new ArrayList<>();
		int cartId;
		String product;
		int nr_of;
		float price, totalprice = 0;
		PurchaseDetail pd;

		for (Cart_detail cart_detail : cart_detailRepository.findAll())
			if (cart_detail.getCartId() == id)
				cart_details.add(cart_detail);

		for (Cart_detail cd : cart_details) {
			cartId = cd.getCartId();
			product = productRepository.findOne(cd.getProductId()).getName();
			nr_of = cd.getNumber_of_products();
			price = nr_of * productRepository.findOne(cd.getProductId()).getPrice();

			pd = new PurchaseDetail(cartId, product, nr_of, price);
			purchase_detail.add(pd);
			totalprice += pd.getPrice();
		}

		return totalprice;

	}

	public List<Purchase> findAllPurchases() {
		//List<Cart> carts = new ArrayList<>();
		List<Purchase> purchases = new ArrayList<>();
		Purchase purchase;
		int cartid;
		float totprice;
		String username;
		for (Cart cart : cartRepository.findAll()) {
			cartid = cart.getId();
			username = customerRepository.findOne(cart.getCustomerId()).getUsername();
			totprice = totalPrice(cartid);
			
			purchase = new Purchase(cartid,username,totprice);
			purchases.add(purchase);
		}
		return purchases;
	}
	

}
