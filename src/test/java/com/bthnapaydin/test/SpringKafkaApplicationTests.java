package com.bthnapaydin.test;

import static org.assertj.core.api.Assertions.assertThat;
import com.bthnapaydin.consumer.Receiver;
import com.bthnapaydin.producer.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by bapaydin on 27.02.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTests {
    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Test
    public void testReceiver() throws InterruptedException {
        sender.sendMessage("helloworld.t","Hello spring kafka!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
    }
}
