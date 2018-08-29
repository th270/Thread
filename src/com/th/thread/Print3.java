package com.th.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/6/8.
 */
public class Print3 {

    private ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    private int flag = 1;
    public void print1() throws InterruptedException {
        lock.lock();
        if ( flag != 1 ) {
            c1.await();
        }
        System.out.print("一");
        System.out.print("二");
        System.out.print("三");
        System.out.print("四");
        System.out.print("五");
        System.out.print("\r\n");
        flag = 2 ;
        c2.signal();
        lock.unlock();
    }

    public void print2() throws InterruptedException {
        lock.lock();
        if ( flag !=2 ) {
            c2.await();
        }
        System.out.print("1-");
        System.out.print("2-");
        System.out.print("3-");
        System.out.print("4-");
        System.out.print("5");
        System.out.print("\r\n");

        flag = 3;
        c3.signal();
        lock.unlock();
    }


    public  void print3() throws InterruptedException {
        lock.lock();
        if ( flag !=3 ) {
            c3.await();
        }
        System.out.print("a-");
        System.out.print("b-");
        System.out.print("c-");
        System.out.print("4-");
        System.out.print("5");
        System.out.print("\r\n");

        flag = 1;
        c1.signal();
        lock.unlock();
    }

}
