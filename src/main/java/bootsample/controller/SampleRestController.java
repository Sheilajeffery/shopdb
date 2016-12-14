package bootsample.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Customer;
import bootsample.service.CustomerService;

@RestController
public class SampleRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello sheila!!";
	}
/*
	@GetMapping("/all-customers")
	public String allCustomers() {
		return customerService.findAll().toString();

	}

	@GetMapping("/save-customer")
	public String saveCustomer(@RequestParam String username, @RequestParam String password, @RequestParam String email,
			@RequestParam String surname, @RequestParam String name, @RequestParam String address,
			@RequestParam String phone, @RequestParam String cnp) {
		Customer customer = new Customer(username, password, email, surname, name, address, phone, cnp);
		customerService.save(customer);

		return "Customer saved!";
	}
	
	@GetMapping("/delete-customer")
	public String deleteCustomer(@RequestParam int id){
		customerService.delete(id);
		
		return "Customer deleted!" ;
		
	}
*/
}