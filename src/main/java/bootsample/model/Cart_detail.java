package bootsample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class Cart_detail implements Serializable {
	
	@Id
	@Column(name="cart_detailID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private int cartId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private int productId;
	
	private int number_of_products;
	
	
	
	
}
