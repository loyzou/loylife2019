package org.loy.common.config;

import org.loy.common.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    /***
     * 设置队列名称
     */
    @Bean
    public Queue loyQueue(){
        return new Queue(RabbitMqConstant.RABBIT_QUEUE_LOY, true);
    }

    /**
     * 设置交换机
     */
    @Bean
    public DirectExchange loyDirectExchange(){
        return new DirectExchange(RabbitMqConstant.RABBIT_EXCHANGE_LOY);
    }

    /**
     * 绑定交换机与队列
     */
    @Bean
    public Binding bindingExchangeAndQueue(){
        return BindingBuilder.bind(loyQueue()).to(loyDirectExchange()).with(RabbitMqConstant.RABBIT_ROUTING_LOY);
    }

}
