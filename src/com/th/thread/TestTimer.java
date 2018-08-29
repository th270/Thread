package com.th.thread;

import java.util.Date;
import java.util.Timer;

/**
 * Created by Administrator on 2018/6/8.
 *
 * Timer类
 */
public class TestTimer {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("开始测试Timer中的方法: ");
        Timer timer = new Timer();
        //testSchedule(timer);

        //testScheduleFirstTimePeriod(timer);

        //testScheduleDelay(timer);

        //testScheduleDelayPeriod(timer);

        testScheduleAtFixedRate(timer);

    }

    /**
     *  跟testScheduleDelayPeriod 类似
     * @param timer
     */
    private static void testScheduleAtFixedRate(Timer timer) {
        timer.scheduleAtFixedRate(new MyTask("testScheduleAtFixedRate"),3*1000,1*1000);
    }

    /**
     * 安排指定的任务从指定的延迟后开始进行重复的固定延迟执行。以近似固定的时间间隔（由指定的周期分隔）进行后续执行。
     * @param timer
     */
    private static void testScheduleDelayPeriod(Timer timer) {
        /**
         * task - 所要安排的任务。
         * delay - 执行任务前的延迟时间，单位是毫秒。(首次执行该任务之前延迟的时间)
         * period - 执行各后续任务之间的时间间隔，单位是毫秒。（以后每次执行该任务的频率）
         */
        timer.schedule(new MyTask("testScheduleDelayPeriod"),3*1000,2*1000);
    }


    /**
     * 安排在指定延迟后执行指定的任务。
     * @param timer
     */
    private static void testScheduleDelay(Timer timer) {
        /**
         * delay 时间后开始执行这个任务
         */
        timer.schedule(new MyTask("testScheduleDelay"),3*1000);
    }

    /**
     *
     * @param timer
     */
    private static void testScheduleFirstTimePeriod(Timer timer) {
        /**
         * task - 所要安排的任务。
         * firstTime - 首次执行任务的时间。
         * period - 循环执行这个任务频率（多久执行一次）。
         * 如果该任务执行的时间超过了period时间:上次任务执行完后立马开始执行下一次任务。
         */
        timer.schedule(new MyTask("testScheduleFirstTimePeriod"),new Date(),3000);
    }

    /**
     * 安排在指定的时间执行指定的任务。如果此时间已过去，则安排立即执行该任务。
     * @param timer
     */
    private static void testSchedule(Timer timer) {
        timer.schedule(new MyTask("testSchedule"),new Date() );
    }


}
