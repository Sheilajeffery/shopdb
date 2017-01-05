package bootsample.model.shop;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="cart")
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cartID")
	private int id;
	private int customerId;
	
	public Cart(){}
	
	

	public Cart(int customerId) {
		super();
		this.customerId = customerId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
