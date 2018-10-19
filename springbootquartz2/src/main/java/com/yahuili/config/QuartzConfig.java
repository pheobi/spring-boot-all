package com.yahuili.config;

import org.quartz.Scheduler;
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

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean  = new SchedulerFactoryBean();
        return  schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler(){
        return schedulerFactoryBean().getScheduler();
    }
}
