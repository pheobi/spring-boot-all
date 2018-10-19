package com.yahuili.task;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class BaseTask implements Job{
    @Autowired
    private Scheduler scheduler;
    @PostConstruct//等同于 init-method
    public  void  init(){
        //需要定义jobDetail
        //(此处的jobName可通过设置get方法替换或者如下  可支持多个task)
        JobDetail jobDetail = JobBuilder.newJob(this.getClass())
                .withIdentity(this.getClass().getSimpleName()+"_job",this.getClass().getSimpleName()+"_group").build();
        //定义trigger
        //SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        //Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();
        String cronExpression = getCronExpression();//我们希望的是，子类进行提供
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(this.getClass().getSimpleName()+"_trigger",this.getClass().getSimpleName()+"_group")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();        //启动job
        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        //删除定时任务
/*        try {
            scheduler.deleteJob(new JobKey("job1","group1"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*/
    }
    public String getCronExpression() {
        return null;
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //这里并没有真正意义上的实现
    }

}
