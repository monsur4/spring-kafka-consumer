package com.mon.kafka.springkafkaconsumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class Config {

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"aricuat.anp:9094");
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "spring-group-2");
        map.put(ConsumerConfig.CLIENT_ID_CONFIG, "anp-producer");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        map.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        map.put("security.protocol", "SSL");
        map.put("ssl.key.password","123456");
        map.put("ssl.keystore.location","src/client.keystore.jks");
        map.put("ssl.keystore.password","123456");
        map.put("ssl.truststore.location","src/truststore.jks");
        map.put("ssl.truststore.password","123456");
        return new DefaultKafkaConsumerFactory<>(map);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> obj = new ConcurrentKafkaListenerContainerFactory<>();
        obj.setConsumerFactory(consumerFactory());
        return obj;
    }
}
