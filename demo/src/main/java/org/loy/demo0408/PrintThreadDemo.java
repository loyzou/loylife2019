package org.loy.demo0408;

public class PrintThreadDemo extends Thread {

    @Override
    public void run() {
       new Foo().one();
    }

    public static void main(String[] args) {
        PrintThreadDemo t1 = new PrintThreadDemo();
        PrintThreadDemo t2 = new PrintThreadDemo();
        PrintThreadDemo t3 = new PrintThreadDemo();

        t1.start();
        t2.start();
        t3.start();
    }
}
