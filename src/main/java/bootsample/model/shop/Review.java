package bootsample.model.shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="review")
public class Review {

	@Id
	@Column(name="reviewID")
	private int id;
	
	private int productId;
	
	private String text;
	
	public Review(int productId, String text) {
		super();
		this.productId = productId;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
