package org.loy.common.dao;

import org.loy.common.context.LoyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

public class BaseService {
    private final String QUERY = "query";
    private final String UPDATE = "update";
    private final String DELETE = "delete";
    private final String COUNT = "count";

    @Autowired
    @Qualifier("daoMyBatisImpl")
    private Dao dao;

    private Dao getDao(){
        return dao;
    }

    /***
     * 默认query查询
     * @param namespace
     * @param database
     * @return
     */
    public LoyResult query(String namespace,String database){
        LoyResult result = new LoyResult();
        List<Map<String,Object>> dataList = getDao().query(namespace,QUERY,database);
        result.setRows(dataList);
        return result;
    }

    /***
     * 指定id查询
     * @param namespace
     * @param statement
     * @param database
     * @return
     */
    public LoyResult query(String namespace,String statement, String database){
        LoyResult result = new LoyResult();
        List<Map<String,Object>> dataList = getDao().query(namespace,statement,database);
        result.setRows(dataList);
        return result;
    }
}
