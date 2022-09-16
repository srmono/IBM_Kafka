package com.ibm.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static  final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "wikiGroup"
    )
    private  void consumer(String eventMessage){
        LOGGER.info(String.format("Event Message Received -> %s", eventMessage));
    }

}
