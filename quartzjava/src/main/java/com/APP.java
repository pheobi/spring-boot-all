package com;

import com.yahuili.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

//@SpringBootApplication
public class APP {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //SpringApplication.run(APP.class,args);

        /*
        * 1.获取到Scheduler实例 并且啓動任務調度器
        * 2.创建具体的任务jobDetail
        * 3.创建触发时间点trigger;
        * 4.将jobDetail和trigger交由schedeler安排触发
        * 5.睡眠20秒，关闭定时任务调度器。
        * */

        System.out.println("scheduler.start");
       //1.获取到Scheduler实例：
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();//启动任务调度器
        System.out.println(scheduler.getSchedulerName());
        //2.创建具体的任务jobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").build();
        //3.创建触发时间点trigger;
        //--触发时间点（每5秒执行一次）--也可以使用cron表达式
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(scheduleBuilder).build();
        //4.将jobDetail和trigger交由schedeler安排触发
        scheduler.scheduleJob(jobDetail,trigger);
        //5.睡眠20秒，关闭定时任务调度器。
        TimeUnit.SECONDS.sleep(20);
        scheduler.shutdown();
        System.out.println("scheduler.shutdown.");
    }
}

