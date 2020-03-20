/*
package org.loy.mq.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

*/
/***
 * MQ消费接收者
 *//*

public class RabbitMqConsumer implements Consumer {
    @Override
    public void handleConsumeOk(String consumerTag) {
        System.out.println("1");
    }

    @Override
    public void handleCancelOk(String consumerTag) {
        System.out.println("2");
    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {
        System.out.println("3");
    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
        System.out.println("4");
    }

    @Override
    public void handleRecoverOk(String consumerTag) {
        System.out.println("5");
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println("6");
    }
}
*/
