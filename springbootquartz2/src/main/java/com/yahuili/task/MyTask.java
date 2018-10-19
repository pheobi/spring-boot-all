package com.yahuili.task;

import com.yahuili.job.HelloJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyTask {
    @Autowired
    private Scheduler scheduler;
    @PostConstruct//等同于 init-method
    public  void  init(){
        //需要定义jobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").build();
        //定义trigger
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();
        //启动job
        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
