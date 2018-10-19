package com.yahuili.config;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/*
* quartz的配置类
* 1.schedulerFactoryBean
* 2.scheduler类
* */
@Configuration
public class QuartzConfig {
    @Autowired
    private SpringBeanJobFactory springBeanJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean  = new SchedulerFactoryBean();
        //吧job交给spring来管理  这样job就能使用spring产生的bean了
        schedulerFactoryBean.setJobFactory(springBeanJobFactory);
        return  schedulerFactoryBean;
    }
    @Bean
    public Scheduler scheduler(){
        return schedulerFactoryBean().getScheduler();
    }
}
