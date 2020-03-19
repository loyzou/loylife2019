package org.loy.common.dao;

import org.loy.common.context.LoyParam;
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
    private final String INSERT = "insert";

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

    /***
     * 默认query查询
     * @param loyParam
     * @param namespace
     * @param statement
     * @return
     */
    public LoyResult query(LoyParam loyParam,String namespace, String statement){
        LoyResult result = new LoyResult();
        if(loyParam.getAttr().size() == 0){
            result.setRows(getDao().query(namespace,statement,loyParam.getDatabase()));
        }else{
            result.setRows(getDao().query(namespace,statement,loyParam.getAttr(),loyParam.getDatabase()));
        }
        return result;
    }


    /***
     * 更新
     * @param loyParam
     * @param namespace
     * @return
     */
    public LoyResult update(LoyParam loyParam,String namespace){
        LoyResult result = new LoyResult();
        int updateSize = getDao().update(namespace,UPDATE,loyParam.getDatabase(),loyParam.getAttr());
        result.putAttr("updateSize",updateSize);
        return result;
    }

    /***
     * 更新
     * @param loyParam
     * @param namespace
     * @return
     */
    public LoyResult insert(LoyParam loyParam,String namespace){
        LoyResult result = new LoyResult();
        int insertSize = getDao().insert(namespace,INSERT,loyParam.getDatabase(),loyParam.getAttr());
        result.putAttr("insertSize",insertSize);
        return result;
    }

    /***
     * 删除
     * @param loyParam
     * @param namespace
     * @return
     */
    public LoyResult delete(LoyParam loyParam,String namespace){
        LoyResult result = new LoyResult();
        int delSize = getDao().insert(namespace,DELETE,loyParam.getDatabase(),loyParam.getAttr());
        result.putAttr("delSize",delSize);
        return result;
    }
}
