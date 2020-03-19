package org.loy.common.context;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class LoyResult implements Serializable {
    public LoyResult(){
    }

    public String message;

    private boolean isSuccess = true;

    private List<Map<String,Object>> rows;

    private Map<String,Object> attr;

    public boolean isSuccess() {
        return isSuccess;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

    public void putAttr(String key, Object value){
        this.attr.put(key,value);
    }

    public Object getAttr(String key){
        return this.attr.get(key);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
