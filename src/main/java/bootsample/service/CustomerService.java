package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootsample.dao.customers.CustomerRepository;
import bootsample.model.customers.Customer;


@Transactional
@Service
public class CustomerService {

	
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {

		List<Customer> customers = new ArrayList<>();

		for (Customer customer : customerRepository.findAll()) {
			customers.add(customer);
		}
		return customers;
	}

	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer findCustomer(int id)
	{
		return customerRepository.findOne(id);
	}
	
	public void delete(int id){
		customerRepository.delete(id);
		
	}

	public Customer findByUsername(String username){
		
		for (Customer customer : customerRepository.findAll()) {
			if (customer.getUsername().equals(username))
			return customer;
		}
		return null;
		
	}
	
}
