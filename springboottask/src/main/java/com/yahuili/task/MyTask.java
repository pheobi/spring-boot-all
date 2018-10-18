package com.yahuili.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/*
MyTask.test2()
MyTask.test1()
MyTask.test1()
MyTask.test1()
MyTask.test1()
MyTask.test1()
MyTask.test2()
-----------------
task1:每10秒打印一次
task2:每1分钟打印一次
---
1分钟是60秒=每打印6次task1之后才能够打印1次task2
spring task 在计算时间的时候，是根据当前服务器的系统时间计算的
如果是每10秒执行一次的话，那么他是从系统时间的0,10,20秒进行计算的
如果是这样的话，那么就会出现5秒之后会执行一次task1和task2
* */
/*@Configuration
@EnableScheduling//开启对类的支持
public class MyTask {
    *//*
    * 我们希望这个方法每10秒打印一次
    * cron：定时任务表达式
    *
    * 指定：秒，分钟，小时，日期，月份，星期，年（可选）
    * *：任意
    * ?:不想设置的值
    * *//*
    @Scheduled(cron = "0/10 * * * * *")//开启对方法的支持
    //@Scheduled(cron = "0/10 * * * * ?")
    public void  test1(){
        System.out.println("MyTask.test1(),"+new Date());
    }
    *//* 我们希望这个方法每1分鐘打印一次 *//*
    @Scheduled(cron = "0 0/1 * * * *")
    public void  test2(){
        System.out.println("MyTask.test2()，"+new Date());
    }
}*/
