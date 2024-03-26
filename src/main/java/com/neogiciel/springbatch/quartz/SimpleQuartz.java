package com.neogiciel.springbatch.quartz;

import java.util.Date;
import java.util.TimeZone;
import java.util.Map;


import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.neogiciel.springbatch.service.BddManager;
import com.neogiciel.springbatch.util.Trace;

@Component
public class SimpleQuartz {

	/*
	 * Constructeur
	 */
	/*public SimpleQuartz(){

	}*/
	  /*
	  * initSimpleTrigger
	  */	
      public void initSimpleTrigger(BddManager bdd)   {

		Trace.info("[SimpleQuartz] init");

		try{
			//Job Creation
			JobDataMap map = new JobDataMap();
			map.put("message", "SimpleJob");
			map.put("bdd", bdd);


			JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("SimpleJob", "group1").setJobData(map).build();
			
			//Simple Trigger
			Date startTime = DateBuilder.nextGivenSecondDate(null, 10);
			SimpleTrigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("FourTimesTrigger", "group1")
				.startAt(startTime)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(10)
				.withRepeatCount(4)).build();
		
			//Scheduler
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);


		} catch (Exception e) {
		e.printStackTrace();
	  	}

      }

	 /*
	  * initCronTrigger
	  */	
	  public void initCronTrigger(BddManager bdd)   {

		Trace.info("[SimpleQuartz] init");

		try{
			//Job Creation
			JobDataMap map = new JobDataMap();
			map.put("message", "SimpleJob");
			map.put("bdd", bdd);


			JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("SimpleJob", "group1").setJobData(map).build();
			
			
			//Cron Trigger
			CronTrigger trigger = TriggerBuilder.newTrigger()
  			.withIdentity("trigger3", "group1")
  			//.withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?"))
			.withSchedule(CronScheduleBuilder.cronSchedule("1 * * * * ?"))
  			.forJob("SimpleJob", "group1")
  			.build();


			//Scheduler
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
			


		} catch (Exception e) {
		e.printStackTrace();
	  	}

      }


}
