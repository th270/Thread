package com.th.thread;

/**
 * Created by Administrator on 2018/6/7.
 */
public class newThread {

    public static void main(String[] args) {

        // 1- 创建线程方法1 继承Thread
        new Thread("thread0"){

            @Override
            public void run() {
                // 这里的this就是Thread 的对象
                String name = this.getName();
                System.out.println(this.getName());
            }

        }.start();

        // 2- 创建线程方法2 实现Runnable
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                //而这里的this 其实是 Runnable 的对象， 所以必须要获取当前线程的对象，才能调用Thread类中的一些方法
                System.out.println(Thread.currentThread().getName());
            }

        }, "thread1");

        thread1.start();

        boolean alive = thread1.isAlive();

        if ( !alive ) {

            thread1.setDaemon(true);

        }
    }
}
