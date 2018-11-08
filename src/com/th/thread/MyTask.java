package com.th.thread;

import java.util.TimerTask;

/**
 * Created by Administrator on 2018/6/8.
 */
public class MyTask extends TimerTask {

    private String taskName ;

    /**
     * 我的任务
     * @param taskName
     */
    public MyTask(String taskName) {

        this.taskName = taskName;

    }

    @Override
    public void run() {

        System.out.println("Start My Task is : " + taskName);

        try {

            Thread.sleep(5*1000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println("End My Task is : " + taskName);

    }
}
