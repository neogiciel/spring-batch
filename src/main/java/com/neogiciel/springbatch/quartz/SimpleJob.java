package com.neogiciel.springbatch.quartz;

import com.neogiciel.springbatch.service.BddManager;
import com.neogiciel.springbatch.service.BddManagerImpl;
import com.neogiciel.springbatch.util.Trace;
import com.mchange.v2.beans.swing.TestBean;
import com.neogiciel.springbatch.model.ExecutionJob;


import jakarta.persistence.PersistenceContext;


import java.util.concurrent.ExecutionException;

import org.apache.catalina.core.ApplicationContext;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

public class SimpleJob implements Job
{
	//BddManager
	private BddManager bdd;

	public void execute(JobExecutionContext context)  {
		Trace.info("[SimpleJob] Hello Quartz! :");	

		try{

 			JobDataMap dataMap = context.getJobDetail().getJobDataMap();
			String message = (String) dataMap.get("message");
			Trace.info("[SimpleJob] message = "+message);	
		
			BddManager bdd = (BddManager) dataMap.get("bdd");
			
			//Actif
			bdd.setActif("Y");

			//Tratement ici
			Thread.sleep(5000);

			//Non Actif
			bdd.setActif("N");

	
		}catch(Exception e){
			Trace.info("[SimpleJob] Exception = "+e.getMessage());	
		}

		
	}
	
}