package com.bthnapaydin.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by bapaydin on 27.02.2017.
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "helloworld.t")
    public void receiveMessage(String message) {
        LOGGER.info("Received message : " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
