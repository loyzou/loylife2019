package org.loy.common.core;

import lombok.extern.slf4j.Slf4j;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/***
 * 反射调用实现类
 */
@Slf4j
@Service("loyInvoke")
public class LoyInvokeImpl implements LoyInvoke {
    @Override
    public LoyResult invoke(LoyParam params) {
        LoyResult result = new LoyResult();
        // 开启事务
        //beginTx(txType);

        // 进行反射调用
        try {

            Object service = LoySpringContext.getBean(params.getServiceName());
            Method method = service.getClass().getMethod(params.getMethod(), new Class[]{LoyParam.class});
            result = (LoyResult) method.invoke(service,new Object[]{params});
        }catch (Exception e){
            log.error("invoke fail" + e.getCause());

            // 回滚事务

        }finally {
            //endTx(txType);
        }

        return result;
    }
}
