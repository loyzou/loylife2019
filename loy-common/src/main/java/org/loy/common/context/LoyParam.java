package org.loy.common.context;

import java.io.Serializable;
import java.util.Map;

/***
 * 传入参数对象
 */
public class LoyParam implements Serializable {
    private String serviceName;
    private String method;
    private Map<String,Object> attr;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }

}
