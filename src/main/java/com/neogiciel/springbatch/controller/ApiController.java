package com.neogiciel.springbatch.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neogiciel.springbatch.quartz.SimpleQuartz;
import com.neogiciel.springbatch.service.BddManager;
import com.neogiciel.springbatch.util.Trace;


@RestController
public class ApiController {
    
    //BddManager
    @Autowired
    BddManager bdd;


    @GetMapping
    @RequestMapping("/")
    public Map home() {
        Trace.info("[ApiController] appel /");
        //bdd.setActif("Y");
        Map map = Map.of("test","test");
        
        return map;
    }

    @GetMapping
    @RequestMapping("/simple")
    public Map simple() {
        Trace.info("[ApiController] appel /simple");
        SimpleQuartz simple = new SimpleQuartz();
        simple.initSimpleTrigger(bdd);
        return Map.of("simple","initSimpleTrigger");
        
    }

    @GetMapping
    @RequestMapping("/cron")
    public Map cron() {
        Trace.info("[ApiController] appel /cron");
        SimpleQuartz simple = new SimpleQuartz();
        simple.initCronTrigger(bdd);
        return Map.of("test","initCronTrigger");
        
    }


}


