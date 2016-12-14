package bootsample.dao;

import org.springframework.data.repository.CrudRepository;
import bootsample.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
