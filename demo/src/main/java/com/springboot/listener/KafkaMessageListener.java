package com.springboot.listener;

import com.springboot.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @KafkaListener(topics = "test", groupId = "test-consumer")
    @KafkaListener(groupId = "test-consumer",
            topicPartitions = @TopicPartition(topic = "test", partitions = { "0", "1" }))

// 1
    public void listen(@Payload Message message,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("接收消息: {}，partition：{}", message, partition);
    }
}
