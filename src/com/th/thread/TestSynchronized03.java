package com.th.thread;

/**
 * Created by Administrator on 2018/6/7.
 */
public class TestSynchronized03 {

    public static void main(String[] args) {

        Print03 print1 = new Print03();
        Print03 print2 = new Print03();

        new Thread(){
            @Override
            public void run() {
                while ( true ){
                    Print03.print1();
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while ( true ){
                    print1.print2();
                }
            }
        }).start();
    }
}

class Print03{
    // 静态同步方法的锁对象是该对象的字节码对象
    public static synchronized void print1()  {

        System.out.print("一");
        System.out.print("二");
        System.out.print("三");
        System.out.print("四");
        System.out.print("五");
        System.out.print("\r\n");

    }

    public void print2()   {
        // 这个同步代码块要跟上面静态同步方法同步 锁对象就要是该类的字节码对象
        synchronized (Print03.class){

            System.out.print("1-");
            System.out.print("2-");
            System.out.print("3-");
            System.out.print("4-");
            System.out.print("5");
            System.out.print("\r\n");

        }
    }
}

