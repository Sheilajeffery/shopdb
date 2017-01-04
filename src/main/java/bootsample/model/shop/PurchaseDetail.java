package bootsample.model.shop;

public class PurchaseDetail {
	
	private int cartid;
	private String product;
	private int nr_of;
	private float price;
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getNr_of() {
		return nr_of;
	}
	public void setNr_of(int nr_of) {
		this.nr_of = nr_of;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice() {
		this.price = price;
	}
	public PurchaseDetail(int cartid, String product, int nr_of, float price) {
		super();
		this.cartid = cartid;
		this.product = product;
		this.nr_of = nr_of;
		this.price = price;
	}
	
	

}
