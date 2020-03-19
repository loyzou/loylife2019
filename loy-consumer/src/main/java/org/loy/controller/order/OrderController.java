package org.loy.controller.order;

import org.loy.api.ILoyApi;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.loy.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/order/")
public class OrderController extends BaseController {
    @Autowired
    private ILoyApi iLoyApi;
    @Autowired
    RedisTemplate redisTemplate;

    /***
     * 查询订单列表
     * @return
     */
    @RequestMapping("queryOrderList")
    public LoyResult queryOrderList(){
        LoyParam loyParam = new LoyParam("orderService", "queryOrderList");
        LoyResult result = iLoyApi.callNoTx(loyParam);
        return result;
    }

    @RequestMapping("queryByRedis")
    public LoyResult queryByRedis(){
        LoyResult loyResult = new LoyResult();
        String loy = (String)redisTemplate.opsForValue().get("loy");
        if(StringUtils.isEmpty(loy)){
            redisTemplate.opsForValue().set("loy","loy2");
        }
        loyResult.setMessage(loy);
        return loyResult;
    }

    /***
     * 更新信息
     * @return
     */
    @RequestMapping("updateOrderInfo")
    public LoyResult updateOrderInfo(){
        LoyParam loyParam = new LoyParam("orderService", "update");
        loyParam.addAttr("orderNo", request.getParameter("orderNo"));
        loyParam.addAttr("orderStatus", request.getParameter("orderStatus"));
        LoyResult loyResult = iLoyApi.call(loyParam);
        return loyResult;
    }

    /***添加信息
     *
     * @return
     */
    @RequestMapping("addOrderInfo")
    public LoyResult addOrderInfo(){
        LoyParam loyParam = new LoyParam("orderService", "insert");
        loyParam.addAttr("recName", "loy");
        LoyResult loyResult = iLoyApi.call(loyParam);
        return loyResult;
    }

    /***删除信息
     *
     * @return
     */
    @RequestMapping("delOrderInfo")
    public LoyResult delOrderInfo(){
        LoyParam loyParam = new LoyParam("orderService", "delete");
        loyParam.addAttr("orderId", request.getParameter("orderId"));
        LoyResult loyResult = iLoyApi.call(loyParam);
        return loyResult;
    }
}
