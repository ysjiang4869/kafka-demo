package org.jys.learn.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author jiangyuesong
 * @date 2018/12/12
 * @description <p> </p>
 */
@Component
public class SpringKafkaProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public SpringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 10)
    public void sendData(){
        String message=Instant.now().toString();
        kafkaTemplate.send("test1",message);
        kafkaTemplate.send("test2",message);
    }
}
