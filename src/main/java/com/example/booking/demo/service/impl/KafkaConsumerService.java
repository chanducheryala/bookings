package com.example.booking.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "event_booking", groupId = "group_id")
    public void consume(String message) {
        log.info("message recieved is : {}", message);
    }
}
