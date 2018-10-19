package com.yahuili.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyTask2 extends BaseTask{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MyTask2.execute().new,date="+new Date());
    }
    @Override
    public String getCronExpression(){
        return "0/4 * * * * ?";//每3秒一次
    }
}
