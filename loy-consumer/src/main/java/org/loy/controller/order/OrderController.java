package org.loy.controller.order;

import org.loy.api.ILoyApi;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.loy.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/account/order/")
public class OrderController extends BaseController {
    @Autowired
    private ILoyApi iLoyApi;

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
}
