package org.loy.mq.receive;

import org.loy.common.constant.RabbitMqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
@RabbitListener(queues = {RabbitMqConstant.RABBIT_QUEUE_LOY}) // 监听队列的名称
public class OrderReceive {
    static {
        System.out.println("orderReceive static init");
    }

    @PostConstruct
    public void testPostCut(){
        System.out.println("test PostCut");
    }

    @RabbitHandler
    public void message(Map<String,Object> msgInfo){
        System.out.println(msgInfo.get("loy"));
    }
}
