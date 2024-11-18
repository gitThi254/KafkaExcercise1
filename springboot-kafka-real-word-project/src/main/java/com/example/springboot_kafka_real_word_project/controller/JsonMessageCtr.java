package com.example.springboot_kafka_real_word_project.controller;

import com.example.springboot_kafka_real_word_project.kafka.JsonKafkaProducer;
import com.example.springboot_kafka_real_word_project.model.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")

public class JsonMessageCtr {
    private final JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageCtr(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/push")
    public ResponseEntity<String> push(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
