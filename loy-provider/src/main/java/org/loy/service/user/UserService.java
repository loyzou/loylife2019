package org.loy.service.user;

import com.sun.deploy.ref.AppRef;
import lombok.extern.slf4j.Slf4j;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.loy.common.dao.BaseService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService extends BaseService {
    private final String NAMESPACE = "USER";
    /***
     * 登录
     * @param params
     * @return
     */
    public LoyResult login(LoyParam params){
        return super.query(NAMESPACE,"queryUserInfo", params.getDatabase());
    }
}
