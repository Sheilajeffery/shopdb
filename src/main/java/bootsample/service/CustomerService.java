package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bootsample.dao.CustomerRepository;
import bootsample.model.Customer;

@Service
@Transactional
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

}
