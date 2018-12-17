package org.jys.learn.kafka.consumer.spring.interfaces.single;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.jys.learn.kafka.utils.RecordLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.kafka.listener.ConsumerAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author jiangyuesong
 * @date 2018/12/12
 * @description <p> </p>
*/
@Component
@ConditionalOnExpression("${spring.kafka.consumer.enable-auto-commit}==true&&${kafka.listener.aware}==true&&${kafka.consumer.batch}==false")
public class SingleBaseAwareListener implements ConsumerAwareMessageListener<String,String> {

    private static final Logger logger= LoggerFactory.getLogger(SingleBaseAwareListener.class);

    @Override
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Consumer<?, ?> consumer) {
        String logs= RecordLogUtils.getRecordLogs(consumerRecord,consumer);
        logger.info(logs);
    }
}
