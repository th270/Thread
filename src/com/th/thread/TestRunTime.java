package com.th.thread;

import org.omg.SendingContext.RunTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018/6/8.
 * RunTime
 */
public class TestRunTime {

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        //Process ipconfig = runtime.exec("ipconfig");
        Process ipconfig = runtime.exec("ping www.baidu.com");
        InputStream inputStream = ipconfig.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ipconfig.getInputStream(),"gbk"));
        String readLine ;
        while ( (readLine = bufferedReader.readLine()) != null ){
            System.out.println(readLine);
        }
    }
}
