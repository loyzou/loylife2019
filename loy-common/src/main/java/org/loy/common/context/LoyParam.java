package org.loy.common.context;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/***
 * 传入参数对象
 */
public class LoyParam implements Serializable {
    private String serviceName;
    private String method;
    private String database;
    private Map<String,Object> attr = new HashMap<>();

    public LoyParam(String serviceName, String method) {
        this.serviceName = serviceName;
        this.method = method;
    }

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

    public void addAttr(String key, Object value){
        this.attr.put(key,value);
    }

    public Object getAttr(String key){
        return this.attr.get(key);
    }

    public String getDatabase() {
        if(StringUtils.isEmpty(database)){
            return "";
        }
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
