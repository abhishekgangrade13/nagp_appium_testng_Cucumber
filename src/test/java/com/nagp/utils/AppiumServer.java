package com.nagp.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {
    final static Logger log = Logger.getLogger(AppiumServer.class);
    public static AppiumDriverLocalService service;

    public static void start(){
        //starting Appium Server
        try{
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

    public void startServer(){
        CommandLine cmd = new CommandLine(ConfigFileReader.getConfigPropertyVal("NodePath"));
        cmd.addArgument(ConfigFileReader.getConfigPropertyVal("mainJSPath"));
        cmd.addArgument("--address");
        cmd.addArgument(ConfigFileReader.getConfigPropertyVal("AppiumServer"));
        cmd.addArgument("--port");
        cmd.addArgument(ConfigFileReader.getConfigPropertyVal("AppiumPort"));

        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try{
            executor.execute(cmd,handler);
            Thread.sleep(10000);
        }catch (IOException|InterruptedException e){
            log.info("error message in starting server - "+e.getMessage());
        }
        log.info("Server started.");
    }


    public void stopServer(){
        Runtime runtime = Runtime.getRuntime();
        try{
            runtime.exec("taskkill /F /IM node.exe");
        }catch (IOException e){
            log.info("error message in stopping server - "+e.getMessage());
        }
        log.info("Server stopped.");
    }

    public boolean checkIfServerIsRunning(int port){
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }catch (IOException e){
            //if control comes here, then it means that port is in use
            isServerRunning = true;
        }finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

}
