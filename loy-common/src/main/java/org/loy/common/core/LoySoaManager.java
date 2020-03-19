package org.loy.common.core;

import lombok.extern.slf4j.Slf4j;
import org.loy.common.context.LoyParam;
import org.loy.common.context.LoyResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;

import java.lang.reflect.Method;

/***
 * 获取本地调用对象
 */
@Component
@Slf4j
public class LoySoaManager {
    private LoySoaManager(){

    }
    private static volatile LoySoaManager loySoaManager;
    private static LoyInvoke loyInvoke;

    public static LoySoaManager getInstance(){
        if(loySoaManager == null){
            synchronized (LoySoaManager.class){
                if(loySoaManager == null){
                    loySoaManager = new LoySoaManager();
                }
            }
        }
        return loySoaManager;
    }

    /***
     * 事务调用
     * @return
     */
    public LoyResult invoke(LoyParam params){
        return call(params, TransactionDefinition.PROPAGATION_REQUIRED);
    }

    /***
     * 无事务调用
     * @return
     */
    public LoyResult callNoTx(LoyParam params){
        return call(params, TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
    }

    /***
     * 调用
     * @param params
     * @param txType
     * @return
     */
    private LoyResult call(LoyParam params, int txType){
        LoyResult result = new LoyResult();
        loyInvoke = LoySpringContext.getBean(LoyInvoke.class);
        result = loyInvoke.invoke(params);
        return result;
    }

}
