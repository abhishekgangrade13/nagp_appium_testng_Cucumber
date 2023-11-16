package com.nagp.utils;

import com.nagp.step_definitions.CreateAccountTest;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.NOPLogger;

public class AppiumServer {
    final static Logger log = Logger.getLogger(AppiumServer.class);
    public static AppiumDriverLocalService service;

    public static void start(){
        //starting Appium Server
        try{
            service.stop();
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
            log.info("Server started.");
        }
        catch (Exception ex){
            log.info("Appium server start to failed- "+ex.getMessage());
        }
    }

    public static void stop(){
        service.stop();
        log.info("Server stopped.");
    }

}
