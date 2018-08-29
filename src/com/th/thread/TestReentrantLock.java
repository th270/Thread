package com.th.thread;

/**
 * Created by Administrator on 2018/6/8.
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        Print3 p = new Print3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while ( true ){
                    try {
                        p.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while ( true ){
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while ( true ){
                    try {
                        p.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
