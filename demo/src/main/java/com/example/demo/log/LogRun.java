package com.example.demo.log;

import ch.qos.logback.core.FileAppender;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogRun {
//    //设定两个Log
//    public static Logger normalLogger = Logger.getLogger("normal.logger");
//    public static Logger exceptionLogger = Logger.getLogger("exception.logger");
//    public static final String PROFILE = "log4j.properties";
//
//    //设定异常log输出的路径
//    private static final String PATH = "log/exception/";
//
//
//    static {
//        URL configFileResource = LogRun.class.getResource(PROFILE);
//        PropertyConfigurator.configure(configFileResource);
//    }
//
//    //构造方法，生成一个新的异常Log文件
//    public LogRun() {
//        try {
//            Date date = new Date();
//            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
//            String fileName = PATH + "exception_" + sf.format(date).toString() + ".log";
//            FileAppender exceptionAppender = new FileAppender(new SimpleLayout(), fileName);
//            exceptionLogger.addAppender(exceptionAppender);
//        } catch (Exception e) {
//            MessageBox.errorBox(e);
//        }
//    }

}