package bootsample.model.shop;

public class Purchase {

	private int cartId;
	private String customerUsername;
	private float price;

	public Purchase(int cartId, String customerUsername, float price) {
		super();
		this.cartId = cartId;
		this.customerUsername = customerUsername;
		this.price = price;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
