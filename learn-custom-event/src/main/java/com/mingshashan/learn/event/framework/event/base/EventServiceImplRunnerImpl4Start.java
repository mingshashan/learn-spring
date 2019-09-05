/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/event/base/EventServiceImplRunnerImpl4Start.java,v 1.1 2013/10/11 17:30:41 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:41 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2004 Primeton Technologies, Ltd.
 * All rights reserved. 
 * 
 * Created on 2006-8-24
 *******************************************************************************/

package com.mingshashan.learn.event.framework.event.base;

import java.lang.reflect.InvocationTargetException;

import com.eos.system.utility.ClassUtil;
import com.primeton.workflow.api.WFRuntimeException;
import com.primeton.workflow.commons.config.WFConfigurationHelper;
import com.primeton.workflow.event.framework.WFEventInterceptor;

/**
 *
 */
public class EventServiceImplRunnerImpl4Start extends EventServiceRunnerImpl {

    public EventServiceImplRunnerImpl4Start() {

    	/*
    	String clazz = WFConfigurationHelper.retrieveWFConfiguration().getProcessScheduler();
        WFEventHandler ps = null,ae = null,eh = null,appHand = null;
		try {
			ps = (WFEventHandler) ClassUtil.newInstance(clazz, null);//new ProcessScheduler();
			
	        clazz = WFConfigurationHelper.retrieveWFConfiguration().getActivityExecuter();
	        ae = (WFEventHandler)ClassUtil.newInstance(clazz, null);//new ActivityExecuter();

	        clazz = WFConfigurationHelper.retrieveWFConfiguration().getExceptionHandler();
	        eh = (WFEventHandler)ClassUtil.newInstance(clazz, null);//new ExceptionHandler();
	        
	        clazz = WFConfigurationHelper.retrieveWFConfiguration().getApplicationHandler();
	        appHand = (WFEventHandler)ClassUtil.newInstance(clazz, null);//new ApplicationHandler();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (LinkageError e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		}
        //PROCESS SCHEDULAR
        registeEventHandler(WFEventType.START_PROCESS, ps);
        registeEventHandler(WFEventType.SCHEDULE_NEXT_ACTIVITY, ps);
        registeEventHandler(WFEventType.BACKWORD_ACTIVITY, ps);
        registeEventHandler(WFEventType.SUSPEND_PROCESS, ps);
        registeEventHandler(WFEventType.RESUME_PROCESS, ps);
        registeEventHandler(WFEventType.CHANGE_PROCESS_STATE, ps);
        registeEventHandler(WFEventType.TERMINATE_PROCESS, ps);
        registeEventHandler(WFEventType.ABORT_PROCESS, ps);
        registeEventHandler(WFEventType.FINISH_PROCESS, ps);
        //ACTIVITY HANDLER
        registeEventHandler(WFEventType.PRESTART_ACTIVITY, ae);//add in v51
        registeEventHandler(WFEventType.START_ACTIVITY, ae);
        registeEventHandler(WFEventType.RESTART_ACTIVITY, ae);
        registeEventHandler(WFEventType.CHANGE_ACTIVITY_STATE, ae);
        registeEventHandler(WFEventType.FINISH_ACTIVITY, ae);
        registeEventHandler(WFEventType.TERMINATE_ACTIVITY, ae);
        registeEventHandler(WFEventType.ABORT_ACTIVITY, ae);
        registeEventHandler(WFEventType.SUSPEND_ACTIVITY, ae);
        registeEventHandler(WFEventType.RESUME_ACTIVITY, ae);

        //EXCEPTION HANDLER
        registeEventHandler(WFEventType.EXCEPTION_PROC_TIMEOUT, eh);
        registeEventHandler(WFEventType.EXCEPTION_PROC_REMIND, eh);
        registeEventHandler(WFEventType.EXCEPTION_WI_TIMEOUT, eh);
        registeEventHandler(WFEventType.EXCEPTION_WI_REMIND, eh);

        //Application Handler
        registeEventHandler(WFEventType.APPLICATION_RETURN, appHand);
        */
    	
    	
    	/*
    	 * 此处后续也会更改，直接从配置文件中读取即可.
    	 */
    	String clazz = "";
        try {
        	clazz = WFConfigurationHelper.retrieveWFConfiguration().getWFEventExceptionInterceptor();
			this.registeEventInterceptor((WFEventInterceptor)ClassUtil.newInstance(clazz, null));
			clazz = WFConfigurationHelper.retrieveWFConfiguration().getWFTxSplitInterceptor();
	        this.registeEventInterceptor((WFEventInterceptor)ClassUtil.newInstance(clazz, null));
	        clazz = WFConfigurationHelper.retrieveWFConfiguration().getWFAuditLogInterceptor();
	        this.registeEventInterceptor((WFEventInterceptor)ClassUtil.newInstance(clazz, null));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		} catch (LinkageError e) {
			e.printStackTrace();
			throw new WFRuntimeException(e);
		}
        
    }
}
