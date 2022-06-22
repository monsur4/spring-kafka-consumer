package com.mon.kafka.springkafkaconsumer.service;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.bson.json.JsonObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "CaseMgmtOut", partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "0")
            })
            /*topics="CaseMgmtOut", groupId = "spring-group-2"*/)
    public void publish(String message/*, Message<String> str*/) throws ParseException {
//        JSONParser jsonParser = new JSONParser(message);
//        JsonObject jsonObject = new JsonObject(message);
//        jsonObject.
//        Object parse = jsonParser.parse();
        System.out.println("This is the new message: " + message /*+ "\n\n\nThis is the str: " + str*/);
    }
}
