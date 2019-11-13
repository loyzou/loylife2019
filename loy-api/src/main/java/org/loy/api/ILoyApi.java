package org.loy.api;

import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${provider.loy.name}")
public interface ILoyApi {
    /***
     * 远程无事务调用
     * @param params
     * @return
     */
    LoyResult callNoTx(LoyParam params);

    /***
     * 远程有事务调用
     * @param params
     * @return
     */
    LoyResult call(LoyParam params);
}
