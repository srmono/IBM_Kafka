package com.ibm.producer.keyproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaKeyProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String TOPIC = "t-multi-paritions";
	
	public void sendWithKey(String key, String value) {
		
		kafkaTemplate.send(TOPIC, key, value);
	} 
}
