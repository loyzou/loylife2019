package org.loy.controller.order;

import org.loy.common.constant.RabbitMqConstant;
import org.loy.common.context.LoyResult;
import org.loy.controller.BaseController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/***
 * 发送mq
 */
@RestController
@RequestMapping("/account/send/")
public class MqSendController extends BaseController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /***
     * 发送mq
     * @return
     */
    @RequestMapping("sendMq")
    public LoyResult sendMq(){
        LoyResult result = new LoyResult();
        Map<String,Object> sendData = new HashMap<>();
        sendData.put("loy","loyQueueTest");
        // 参数说明 1-交换机名称 2-交换机绑定路由 3-data
        rabbitTemplate.convertAndSend(RabbitMqConstant.RABBIT_EXCHANGE_LOY,
                RabbitMqConstant.RABBIT_ROUTING_LOY,sendData);
        return result;
    }
}
