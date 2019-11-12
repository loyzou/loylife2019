package org.loy.api.user;

import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${provider.loy.name}")
public interface UserApi {
    /***
     * 登录
     * @param params
     * @return
     */
    LoyResult login(LoyParam params);
}
