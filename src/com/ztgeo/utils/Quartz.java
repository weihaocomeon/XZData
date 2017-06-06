package com.ztgeo.utils;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.ztgeo.services.Services;
import com.ztgeo.staticParams.StaticParams;

//定时程序
public class Quartz implements Job {
	//声明变量 读取xml
	public static void startQuartz(){
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			//任务具体
			JobDetail job = JobBuilder.newJob(Quartz.class).withIdentity("job1","group1").build();
			//触发器
			Trigger trigger = TriggerBuilder.newTrigger()
					.withSchedule(CronScheduleBuilder.cronSchedule(StaticParams.QuartzTime))
					.forJob("job1","group1").build();
			scheduler.scheduleJob(job,trigger);
			scheduler.start();
			System.out.println("方法准备执行!请确保配置的启动时间有效!");
		} catch (SchedulerException e) {
			System.out.println("定时程序报错,请检查执行时间格式是否正确!!");
		}
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("执行成功!");
		//执行service类
		
		
		
	}
}