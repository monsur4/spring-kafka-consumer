package com.mon.kafka.springkafkaconsumer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaTopicConfig {

//    @Bean
//    public KafkaAdmin kafkaAdmin(){
//        Map<String, Object> config = new HashMap<>();
//        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.100.50:9094");
//        return new KafkaAdmin(config);
//    }
//
//    @Bean
//    public NewTopic newTopic(){
//        return new NewTopic("monsuru", 2, (short)1);
//    }
}
