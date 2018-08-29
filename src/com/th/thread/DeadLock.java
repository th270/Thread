package com.th.thread;

/**
 * Created by Administrator on 2018/6/7.
 * 两个线程 两个锁对象 两个同步代码块嵌套
 * 线程1 获取到第一个锁对象 线程2 获取到第二个锁对象 这个时候两个线程都在等另外一个锁对象，就出现了死锁的情况
 */
public class DeadLock {

    private static String s1 = "筷子1";
    private static String s2 = "筷子2";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while ( true ){
                    synchronized (s1){
                        System.out.println(Thread.currentThread().getName() + " : 获取" + s1 +"等待" + s2);
                        synchronized (s2){
                            System.out.println(Thread.currentThread().getName() + " : 获取"+s2+"开吃！");
                        }
                    }
                }
            }
        },"汤辉").start();

        new Thread("徐玲"){
            @Override
            public void run() {
                while ( true ){
                    synchronized (s2){
                        System.out.println(this.getName() + " : 获取"+s2+"等待"+s1);
                        synchronized (s1){
                            System.out.println(this.getName() + " : 获取" + s1 + "开吃");
                        }
                    }
                }
            }
        }.start();

    }
}
