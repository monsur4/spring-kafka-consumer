package com.mon.kafka.springkafkaconsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaService {

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "CaseMgmtOut", partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "0")
            })
            /*topics="CaseMgmtOut", groupId = "spring-group-2"*/)
    public void publish(String message/*, Message<String> str*/) throws ParseException {
        JSONObject jsonObject = new JSONObject(message);
        if(jsonObject.get("type").equals("CLOSE-CASE")){
            System.out.println("caseIdentifiers for all closed cases: " + jsonObject.get("caseIdentifier"));
        }
    }
}
