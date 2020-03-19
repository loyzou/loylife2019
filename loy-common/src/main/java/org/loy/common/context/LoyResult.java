package org.loy.common.context;

import com.alibaba.fastjson.serializer.SerializerFeature;
import org.loy.common.util.JsonUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoyResult implements Serializable {
    public LoyResult(){
    }

    public String message;

    private boolean isSuccess = true;

    private List<Map<String,Object>> rows;

    private Map<String,Object> attr = new HashMap<>();

    public Map<String, Object> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, Object> attr) {
        if(attr == null) return;
        this.attr = attr;
    }

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

    public String toJson(){
        return JsonUtil.getInstance().object2JSON(this, SerializerFeature.WriteDateUseDateFormat);
    }

}
