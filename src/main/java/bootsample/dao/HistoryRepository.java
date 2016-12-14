package bootsample.dao;

import org.springframework.data.repository.CrudRepository;
import bootsample.model.History;

public interface HistoryRepository  extends CrudRepository<History, Integer>{

}
