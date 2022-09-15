package com.ibm.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	@KafkaListener(topics = "ibmapptopic", groupId = "order_group" )
	public void consumer(String message) {
		System.out.println("Order Info: " + message);
	}
}
