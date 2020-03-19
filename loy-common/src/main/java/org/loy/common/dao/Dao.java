package org.loy.common.dao;

import java.util.List;
import java.util.Map;

public interface Dao {
    /***
     * 查询
     * @param namespace
     * @param statement
     * @param database
     * @return
     */
    List<Map<String,Object>> query(String namespace, String statement, String database);

    /***
     * 条件查询
     * @param namespace
     * @param statement
     * @param params
     * @param database
     * @return
     */
    List<Map<String,Object>> query(String namespace, String statement, Map<String,Object> params, String database);

    /***
     * 查询(分页)
     * @param namespace
     * @param statement
     * @param database
     * @return
     */
    List<Map<String,Object>> query(String namespace, String statement, int limit, int offset, String database);

    /***
     * 更新
     * @param namespace
     * @param statement
     * @return
     */
    int update(String namespace,String statement,String database,Map<String,Object> params);

    /***
     * 插入
     */
    int insert(String namespace,String statement, String database ,Map<String,Object> params);

    /***
     * 删除
     */
    int delete(String namespace,String statement, String database ,Map<String,Object> params);

}
