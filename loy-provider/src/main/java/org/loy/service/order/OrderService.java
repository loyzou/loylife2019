package org.loy.service.order;

import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.loy.common.dao.BaseService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class OrderService extends BaseService {
    private final String NAMESPACE = "USER";

    /***
     * 查询订单列表
     * @param params
     * @return
     */
    public LoyResult queryOrderList(LoyParam params){
        return this.query(params,NAMESPACE,"queryOrderList");
    }
}
