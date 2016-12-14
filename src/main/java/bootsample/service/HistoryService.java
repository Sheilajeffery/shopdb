package bootsample.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import bootsample.dao.HistoryRepository;

@Service
@Transactional
public class HistoryService {

	private final HistoryRepository historyRepository;
	
	public HistoryService(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}
}
