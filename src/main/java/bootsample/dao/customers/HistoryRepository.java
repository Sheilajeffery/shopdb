package bootsample.dao.customers;

import org.springframework.data.repository.CrudRepository;

import bootsample.model.customers.History;

public interface HistoryRepository  extends CrudRepository<History, Integer>{

}
