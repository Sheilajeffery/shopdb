package bootsample.dao.customers;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.customers.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
