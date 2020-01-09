package org.loy.common.dao;

import lombok.extern.slf4j.Slf4j;
import org.loy.common.core.LoySpringContext;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/***
 * mybatis Dao实现类
 */
@Slf4j
@Service("daoMyBatisImpl")
public class DaoMyBatisImpl implements Dao {
    private static final String SQLSESSION_TEMPLATE = "sqlSessionTemplate";

    /***
     * 获取session模板对象
     * @param database
     * @return
     */
    private SqlSessionTemplate getDao(String database){
        return (SqlSessionTemplate) LoySpringContext.getBean(database + SQLSESSION_TEMPLATE);
    }

    @Override
    public List<Map<String, Object>> query(String namespace, String statement, String database) {
        long startLongTime = System.currentTimeMillis();
        List<Map<String,Object>> dataList = getDao(database).selectOne(getStatement(namespace,statement));
        log.info("["+namespace +"." + statement+"] execute,cost:" + (System.currentTimeMillis() - startLongTime) + "ms");
        return dataList;
    }

    @Override
    public List<Map<String, Object>> query(String namespace, String statement, Map<String,Object> params, String database) {
        long startLongTime = System.currentTimeMillis();
        List<Map<String,Object>> dataList = getDao(database).selectOne(getStatement(namespace,statement), params);
        log.info("["+namespace +"." + statement+"] execute,cost:" + (System.currentTimeMillis() - startLongTime) + "ms");
        return dataList;
    }

    @Override
    public List<Map<String, Object>> query(String namespace, String statement, int limit, int offset, String database) {
        return null;
    }

    private String getStatement(String namespace, String statement){
        return namespace + "." + statement;
    }

}
