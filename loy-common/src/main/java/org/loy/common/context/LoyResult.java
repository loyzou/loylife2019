package org.loy.common.context;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class LoyResult implements Serializable {
    public LoyResult(){

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

    private boolean isSuccess;

    private List<Map<String,Object>> rows;


}