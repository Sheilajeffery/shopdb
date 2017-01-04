package bootsample.model.shop;

public class Purchase {

	private int cartId;
	private String customerUsernanme;
	private float price;

	public Purchase(int cartId, String customerUsernanme, float price) {
		super();
		this.cartId = cartId;
		this.customerUsernanme = customerUsernanme;
		this.price = price;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCustomerUsernanme() {
		return customerUsernanme;
	}

	public void setCustomerUsernanme(String customerUsernanme) {
		this.customerUsernanme = customerUsernanme;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
