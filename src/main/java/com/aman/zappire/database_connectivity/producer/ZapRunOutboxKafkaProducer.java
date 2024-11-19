package com.aman.zappire.database_connectivity.producer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.aman.zappire.database_connectivity.db_repository.ZapRunOutboxRepository;
import com.aman.zappire.database_connectivity.entities.ZapRunOutbox;

@Service
public class ZapRunOutboxKafkaProducer {
	private static final int PAGE_SIZE=10;
	
	@Autowired
	private ZapRunOutboxRepository zapRunOutRepo;
	
	@Autowired
	private KafkaOutboxProcessor kafkaProducer;
	
	
	// This method will run every 3 seconds, like your Node.js "while (1)"
    @Scheduled(fixedDelay = 3000)  // Run every 3 seconds
    public void processOutbox() {
    	Pageable pageable=PageRequest.of(0,PAGE_SIZE); // to find first page/batch of data of size 10
    	
    	List<ZapRunOutbox> pendingZapruns=zapRunOutRepo.findAll(pageable).getContent(); //used the method mentioned in the repo to fetch data into a list
    	
    	if(!pendingZapruns.isEmpty()) {
    		//sending each record to kafka
    		pendingZapruns.forEach(r->{
    			String message = "{\"zapRunId\":\"" + r.getZapRun().getId() + "\", \"stage\": 0}"; 
    			//r.getZapRun() returns a ZapRun object as a whole so extracted Id using .getId() before using kafka broker
    			kafkaProducer.sendToKafka(message);
    		});
    		
    		//zapRunOutRepo.deleteAll(pendingZapruns);
    	}
    }
}
