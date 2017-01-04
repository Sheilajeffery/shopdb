package bootsample.model.shop;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="cart_detail")
public class Cart_detail implements Serializable {
	
	@Id
	@Column(name="cart_detailID")
	private int id;
	
	private int cartId;

	private int productId;
	
	private int number_of_products;
	
	public Cart_detail(){}
	
	

	public Cart_detail(int cartId, int productId, int number_of_products) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.number_of_products = number_of_products;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getNumber_of_products() {
		return number_of_products;
	}

	public void setNumber_of_products(int number_of_products) {
		this.number_of_products = number_of_products;
	}

	@Override
	public String toString() {
		return "Cart_detail [id=" + id + ", cartId=" + cartId + ", productId=" + productId + ", number_of_products="
				+ number_of_products + "]";
	}
	
	
	
	
}
