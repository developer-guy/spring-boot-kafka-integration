package com.bthnapaydin.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by bapaydin on 27.02.2017.
 */
@Component
public class Sender {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(Sender.class);

    public void sendMessage(String topic, String message) {
        ListenableFuture<SendResult<Integer, String>> send = kafkaTemplate.send(topic, message);

        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                LOGGER.error("Unable to send message " + throwable);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {
                LOGGER.info("Sending message : " + message + " to the topic : " + topic + " and offset : " + integerStringSendResult.getRecordMetadata().offset());
            }
        });
    }
}
