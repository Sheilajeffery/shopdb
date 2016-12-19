package bootsample.model.customers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "history")
public class History implements Serializable {

	@Id
	@Column(name = "historyID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int productID;
	private int customerID;

	public History() {
	}

	public History(int productID, int customerID) {
		super();
		this.productID = productID;
		this.customerID = customerID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}
