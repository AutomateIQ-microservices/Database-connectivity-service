package com.aman.zappire.database_connectivity.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOutboxProcessor {
	private final KafkaTemplate<String,String> kafkaTemplate;
	private static final String TOPIC_NAME="zap-events" ;
	
	public KafkaOutboxProcessor(KafkaTemplate<String,String> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendToKafka(String message) {
		kafkaTemplate.send(TOPIC_NAME,message);
	}
}
