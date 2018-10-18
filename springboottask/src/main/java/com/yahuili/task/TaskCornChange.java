package com.yahuili.task;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
* 思路：
* 1.新建一个task class
* 2.在class上添加注释@EnableScheduling
* 3.让我们的class实现接口SchedulingConfigurer;
* 4.实现SchedulingConfigurer中的方法
* */
/*@RestController
@EnableScheduling
public class TaskCornChange implements SchedulingConfigurer{
    //秒 分钟 小时 日期 月份 星期 年（可选）
    private String expression = "0/5 * * * * *";//每5秒执行一次定时任务
    @RequestMapping("/changeExpression")
    public String changeExpression() {
        expression = "0/10 * * * * *";//每10秒执行一次定时任务
        return "changeExpression";
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = new Runnable(){
            @Override
            public void run() {
                System.out.println("configureTasks.run,"+new Date());
            }
        };
        Trigger trigger =new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger = new CronTrigger(expression);
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        };
        taskRegistrar.addTriggerTask(task,trigger);
    }
}*/
