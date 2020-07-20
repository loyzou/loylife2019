/*
 *
 */
package org.loy.demo_closeable;

/**
 * 实现closeAblede接口的类，可以不用手动在finally进行资源的关闭，执行完try
 * 之后，代码会自动执行close
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/17
 */
public class CloseAbleDemo implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("自动调用close关闭流");
    }

    public static void main(String[] args) {
        try(CloseAbleDemo closeAbleDemo = new CloseAbleDemo()) {
        } catch (Exception e) {
            System.out.println("--exception--");
        }

    }
}
