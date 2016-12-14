package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Customer;
import bootsample.service.CustomerService;

@Controller
public class MainController {

	@Autowired
	private CustomerService customerService;

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

}
