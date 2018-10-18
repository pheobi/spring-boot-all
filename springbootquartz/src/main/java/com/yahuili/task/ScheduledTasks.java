package com.yahuili.task;

import org.springframework.stereotype.Component;

import java.util.Date;
/*
* 任务执行类
* */
@Component
public class ScheduledTasks {
    public void excute(){
        //执行任务
        System.out.println("execute,date="+new Date());
    }
}
