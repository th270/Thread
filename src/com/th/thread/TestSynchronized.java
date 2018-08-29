package com.th.thread;

/**
 * Created by Administrator on 2018/6/7.
 */
public class TestSynchronized {

    public static void main(String[] args) {

        Print print1 = new Print();
        Print print2 = new Print();

        new Thread(){
            @Override
            public void run() {
                while ( true ){
                    print1.print1();
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


class Print{
   public void print1()  {

       // 同步代码块的所对象需要时同一个锁对象，如果不是同一个锁对象，也不是两个同步代码块不属于同一个同步代码块
       // 这里的锁对象是this 也就是说 谁调用这个方法，谁就是这个锁对象
       // 如果这两个方法不是同一个对象调用的，那么这两个同步代码块不属于同一个同步代码块（锁对象不一样）

       synchronized (this){

           System.out.print("一");
           System.out.print("二");
           System.out.print("三");
           System.out.print("四");
           System.out.print("五");
           System.out.print("\r\n");

       }

   }

   public void print2()   {
       // 同步代码块的所对象需要时同一个锁对象，如果不是同一个锁对象，也不是两个同步代码块不属于同一个同步代码块
       // 这里的锁对象是this 也就是说 谁调用这个方法，谁就是这个锁对象
       // 如果这两个方法不是同一个对象调用的，那么这两个同步代码块不属于同一个同步代码块（锁对象不一样）
       synchronized (this){
           System.out.print("1-");
           System.out.print("2-");
           System.out.print("3-");
           System.out.print("4-");
           System.out.print("5");
           System.out.print("\r\n");
       }
   }
}