/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.protoype_demo;

import lombok.Data;

/**
 * 原型类
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/28
 */
@Data
public class LoyProtoType implements Cloneable{
    private String loyName;
    public LoyProtoType(String loyName) {
        this.loyName = loyName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
