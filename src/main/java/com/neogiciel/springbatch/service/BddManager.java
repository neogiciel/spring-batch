package com.neogiciel.springbatch.service;

import java.util.List;

import com.neogiciel.springbatch.model.ExecutionJob;
import com.neogiciel.springbatch.model.Processus;


public interface BddManager {

     /*
     * test()
     */
    public String test();

     /*
     * Table Job
     */
    public List<ExecutionJob> getListExecutionJob();
    public Long addExecutionJob(ExecutionJob job);
    public void modExecutionJob(ExecutionJob job);

    /*
     * Table Actif
     */
    public void setActif(String actif);
    public String getIsActif();
}
