/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.protoype_demo;

/**
 * 设计模式之原型模式Demo
 * 原型模型
 * 【1】适用场景：需要大量复制对象时
 * 【2】优缺点：优点：比直接new对象节省内存
 * 【3】深拷贝-浅拷贝：
 *      Object类的clone方法只会拷贝对象中的基本的数据类型（基本类型及封装类型，String类型也会被拷贝），
 *      对于数组、容器对象、引用对象等都不会拷贝，只会复制对象的引用，这就是浅拷贝。如果要实现深拷贝，
 *      必须将原型模式中的数组、容器对象、引用对象等另行拷贝。
 * 【4】 实现
 *     (1) 实现Cloneable 接口，重写clone()方法
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/28
 */
public class PrototypeDemo implements Cloneable {
    private String name;
    private LoyProtoType loyProtoType;
    public PrototypeDemo(String name, LoyProtoType loyProtoType) {
        this.name = name;
        this.loyProtoType = loyProtoType;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PrototypeDemo{" +
                "name='" + name + '\'' +
                ", loyProtoType=" + loyProtoType +
                '}';
    }

    @Override
    protected PrototypeDemo clone() throws CloneNotSupportedException {
        PrototypeDemo prototypeDemo = (PrototypeDemo) super.clone();
        // 属性对象单独clone
        prototypeDemo.loyProtoType = (LoyProtoType) loyProtoType.clone();
        return prototypeDemo;
    }

    public static void main(String[] args) {
        PrototypeDemo prototypeDemo = new PrototypeDemo("原型1", new LoyProtoType("Loy原型"));
        try {
            PrototypeDemo prototypeDemo1 = prototypeDemo.clone();
            prototypeDemo1.setName("原型2");
            prototypeDemo1.loyProtoType.setLoyName("loy原型2");
            System.out.println(prototypeDemo.toString());
            System.out.println(prototypeDemo1.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



    }
}
