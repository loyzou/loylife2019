package org.loy.service.user;

import lombok.extern.slf4j.Slf4j;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    /***
     * 登录
     * @param params
     * @return
     */
    public LoyResult login(LoyParam params){
        LoyResult result = new LoyResult();
        result.setMessage("登录成功");
        result.setSuccess(true);
        return result;
    }
}
