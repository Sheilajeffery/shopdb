package bootsample.dao.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import bootsample.model.customers.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
