package org.loy.api;

import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "${provider.loy.name}")
public interface ILoyApi {
    /***
     * 远程无事务调用
     * @param params
     * @return
     */
    @RequestMapping("/callNoTx")
    LoyResult callNoTx(LoyParam params);

    /***
     * 远程有事务调用
     * @param params
     * @return
     */
    @RequestMapping("/call")
    LoyResult call(LoyParam params);
}
