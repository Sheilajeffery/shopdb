package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.customers.*;
import bootsample.model.shop.*;
import bootsample.service.*;

@Controller
public class MainController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PurchaseService purchaseService;

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}

	@GetMapping("/all-customers")
	public String allCustomers(HttpServletRequest request) {
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "index";
	}

	@GetMapping("/new-customer")
	public String newCustomer(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute Customer customer, BindingResult bindingResult, HttpServletRequest request) {
		customerService.save(customer);
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "index";
	}

	@GetMapping("/update-customer")
	public String updateCustomer(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("customer", customerService.findCustomer(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}

	@GetMapping("/delete-customer")
	public String deleteCustomer(@RequestParam int id, HttpServletRequest request) {
		customerService.delete(id);
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("mode", "MODE_CUSTOMERS");
		return "index";
	}

	@GetMapping("/home2")
	public String home2(HttpServletRequest request) {
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_HOME2");
		return "produse";
	}

	@GetMapping("/all-products")
	public String allProducts(HttpServletRequest request) {
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "index";
	}

	@GetMapping("/new-product")
	public String newProduct(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW_PRODUCT");
		return "index";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult, HttpServletRequest request) {
		productService.save(product);
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "index";
	}

	@GetMapping("/update-product")
	public String updateProduct(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("product", productService.findProduct(id));
		request.setAttribute("mode", "MODE_UPDATE_PRODUCT");
		return "index";
	}

	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam int id, HttpServletRequest request) {
		productService.delete(id);
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "index";
	}
	
	@GetMapping("/all-cart")
	public String allCarts(HttpServletRequest request) {
		request.setAttribute("carts", cartService.findAll());
		request.setAttribute("mode", "MODE_CARTS");
		return "index";
	}
///	
	@GetMapping("/all-purchases")
	public String allPurchaseDetail(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("purchases", purchaseService.findByCartId(id));
		request.setAttribute("mode", "MODE_PURCHASE");
		return "index";
	}
	
///////	
	@GetMapping("/all-carts")
	public String allPurchases(HttpServletRequest request) {
		request.setAttribute("carts", purchaseService.findAllPurchases());
		request.setAttribute("mode", "MODE_CART");
		return "index";
	}
	
	
	
}
