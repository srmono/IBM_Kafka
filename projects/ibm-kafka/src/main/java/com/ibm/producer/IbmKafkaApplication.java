package com.ibm.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibm.producer.keyproducer.KafkaKeyProducer;

@SpringBootApplication
public class IbmKafkaApplication implements CommandLineRunner {
	
	@Autowired
	private KafkaKeyProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(IbmKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for(int i = 0; i < 30; i++) {
			var key = "Key-"+(i % 4);
			var value = "value " + i +  "with key " + key;
			
			producer.sendWithKey(key, value);
		}
	}

}
