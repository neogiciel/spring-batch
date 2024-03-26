package com.neogiciel.springbatch.simple;

import com.neogiciel.springbatch.service.BddManager;
import com.neogiciel.springbatch.util.Trace;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class SimpleScheduledTask {

    @Autowired
    BddManager bdd;

    @Scheduled(fixedRate=5000)
    //@Scheduled(cron = "0 0 * * * *")
    public void test() throws Exception{
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Trace.info("[SimpleScheduledTask] tache : "+s.format(date));

        //Actif
		bdd.setActif("Y");

        //Tratement ici
        Thread.sleep(5000);

        String isActif = bdd.getIsActif();
        Trace.info("[SimpleScheduledTask] isActif : "+isActif);

		//Non Actif
		bdd.setActif("N");


    }

    
}
