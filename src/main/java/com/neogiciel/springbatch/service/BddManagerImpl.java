package com.neogiciel.springbatch.service;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neogiciel.springbatch.util.Trace;
import com.neogiciel.springbatch.model.ExecutionJob;
import com.neogiciel.springbatch.model.Processus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class BddManagerImpl implements BddManager{
    
    /*
     * EntityManager
     */
    @PersistenceContext
    EntityManager em;
    
    /*
     * Constructeur
     */
    public BddManagerImpl(){
         //EntityManagerFactory emf =Persistence.createEntityManagerFactory("batch");
         //em = emf.createEntityManager();
    }

    /*
     * getListJob
     */
    public String test(){
        Trace.info("[BddManager] test()");
        return "test";
	}

    /*
     * getListJob
     */
    public List<ExecutionJob> getListExecutionJob(){
        Trace.info("[BddManager] select * from EXECUTIONJOB");
        @SuppressWarnings("unchecked")
        List<ExecutionJob> liste =  em.createNativeQuery("select * from EXECUTIONJOB",ExecutionJob.class).getResultList();
        return liste;
	}

   /*
     * addJob
     */
    @Transactional
    public Long addExecutionJob(ExecutionJob executionJob){
        Trace.info("[BddManager] addExecutionJob");
        em.persist(executionJob);
        em.flush();
        Trace.info("[BddManager] id = "+ executionJob.id);
    	return executionJob.id;
    }

    
   /*
     * addJob
     */
    @Transactional
    public void modExecutionJob(ExecutionJob executionJob){
        Trace.info("[BddManager] mod ExecutionJob");
        em.merge(executionJob);
        em.flush();
    }

    /*
     * setActif
     */
    @Transactional
    public void setActif(String actif){
        Trace.info("[BddManager] setActif = "+actif);
        //Regarde si le processus existe
        @SuppressWarnings("unchecked")
        List<Processus> liste =  em.createNativeQuery("select * from PROCESSUS",Processus.class).getResultList();

        if(liste.size()>0){
            Processus processus = liste.get(0);
            processus.actif = actif;
            em.merge(processus);
            em.flush();

        }else{
            Processus processus = new Processus(actif);
            em.persist(processus);
            em.flush();
        }

    }

    /*
     * getIsActif
     */
    public String getIsActif(){
        Trace.info("[BddManager] getIsActif");
        @SuppressWarnings("unchecked")
        List<Processus> liste =  em.createNativeQuery("select * from PROCESSUS",Processus.class).getResultList();
        if(liste.size()>0){
            Processus processus = liste.get(0);
            return processus.actif;
        }
        return "N";
	}

}
