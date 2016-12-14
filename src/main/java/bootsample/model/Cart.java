package bootsample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Cart implements Serializable {
	
	@Id
	@Column(name="cartID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	/*@OneToMany(fetch = FetchType.EAGER, mappedBy = "cart_detail")*/
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "customer")
	private int customerId;
	
	public Cart(){}

}
