package com.ibm.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//
//	private static final String TOPIC = "ibmapptopic";
//	
//	@GetMapping("/publish/{message}")
//	public String publishMessage(@PathVariable("message") final String message) {
//		
//		//logic -> produce success_message
//		
//		
//		//Send message to Kafka topic
//		kafkaTemplate.send(TOPIC, message);
//		
//		//API Response
//		return "Welcome to IBM Kafka Service";
//	}
	
	@Autowired
	KafkaTemplate<String, Order> kafkaTemplate;
	
	private static final String TOPIC = "ibmapptopic";
	
	@PostMapping("/createorder")
	public String sendOrderInfo(@RequestBody Order order) {
		
		kafkaTemplate.send(TOPIC, order);
		
		return "Order Placed Successfully";
	}
	
}


















