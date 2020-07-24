/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.service;

import org.loy.entity.LoyEntity;
import org.loy.mapper.LoyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/24
 */
@Service
public class LoyServiceImpl implements LoyService {
    @Autowired
    private LoyMapper loyMapper;
    @Override
    public List<LoyEntity> listLoy() {
        return loyMapper.listLoy();
    }
}
