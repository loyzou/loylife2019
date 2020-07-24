/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.mapper;

import org.loy.entity.LoyEntity;

import java.util.List;

/**
 * loyMapper
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/24
 */
public interface LoyMapper {
    /**
     * 获取列表信息
     * <p>
     *
     * @param
     * @return
     * @author Loy
     * @date 2020/7/24 16:03
     * @version 1.0.0
     */
    List<LoyEntity> listLoy();
}
