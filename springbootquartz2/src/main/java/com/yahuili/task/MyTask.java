package com.yahuili.task;

import com.yahuili.service.HelloService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class MyTask extends BaseTask{

    /*
    * 爲什麽helloservice=null?
    *-------------------------------------------
    * Quartz中的job是由Quartz框架【动态】创建的《通过配置该job的className,通过反射进行动态创建》，所以
    * 在job中使用spring bean 的话，是无法进行使用的（job是类，不是spring bean）
    *
    * 如何将我们的job交给spring进行管理。
    * --------------------------------
    * 使用AutowireCapableBeanFactory进行自动注入job
    * */
    @Resource
    private HelloService helloService;//null?

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException{
        System.out.println("MyTask.execute().new,date="+new Date());
        helloService.hello();
    }
    @Override
    public String getCronExpression(){
        return "0/3 * * * * ?";//每3秒一次
    }
}
