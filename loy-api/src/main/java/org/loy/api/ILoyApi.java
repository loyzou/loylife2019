package org.loy.api;

import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${provider.loy.name}")
public interface ILoyApi {
    /***
     * 登录
     * @param params
     * @return
     */
    LoyResult login(LoyParam params);
}
