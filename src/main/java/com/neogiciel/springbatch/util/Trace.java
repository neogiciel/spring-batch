package com.neogiciel.springbatch.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Trace
 */
public class Trace {

    boolean logInFile = false;

    /*
    *Logger
    */
    static Logger logger = LoggerFactory.getLogger(Trace.class);
    
    /*
     * Singleton
     */
    static{
		init();
	}

    /*
     * init()
     */
    private static void init() {
        logger.info("========================================");
        logger.info("============ APPLICATION ===============");
        logger.info("========================================");

    }        
    /*
     * info
     */
    public static void info(String message){
        logger.info(message);

    }
    /*
     * debug
     */
    public static void debug(String message){
        logger.debug(message);

    }
    /*
     * warn
     */
    public static void warm(String message){
        logger.warn(message);

    }
        /*
     * Error
     */
    public static void error(String message){
        logger.error(message,"error", new Exception(message));
    }


}
