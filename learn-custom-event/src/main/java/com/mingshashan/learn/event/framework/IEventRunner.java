/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/IEventRunner.java,v 1.1 2013/10/11 17:30:01 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:01 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2004 Primeton Technologies, Ltd.
 * All rights reserved. 
 * 
 * Created on 2006-8-23
 *******************************************************************************/

package com.mingshashan.learn.event.framework;

import com.mingshashan.learn.event.framework.event.base.EventServiceImplRunnerImpl4Start;

/**
 * 事件执行接口
 */
public interface IEventRunner {

	public static IEventRunner INSTANCE = new EventServiceImplRunnerImpl4Start();
	
    /**
     * 处理事件：
     * 如果当前线程已经有一个有效的EventContext，则将为该Context
     * 产生一个子EventContext；否则创建一个EventContext.
     * 处理完毕以后，如果处理以前有有效的EventContext，则设定当前线程的当前EventContext为该EventContext.
     * @param event
     */
    public void process(Event event);

    /**
     * 如果当前线程有有效的EvenContext,则在其中加入event.
     * 否则调用process.
     * @param event
     */
    public void addOrProcessEvent(Event event);
    
    /**
     * 注册EventContext的拦截机
     * 
     * @param aInterc
     */
    public void registeEventCtxInterceptor(WFEventContextInterceptor aInterc);

    /**
     * 删除EventContext的拦截机
     * @param aInterc
     * @return
     */
    public boolean removeEventCtxInterceptor(WFEventContextInterceptor aInterc);
    
    /**
     * 注册Event拦截
     * @param aInterc
     */
    public void registeEventInterceptor(WFEventInterceptor aInterc);

    /**
     * 删除事件拦截
     * @param aInterc
     * @return
     */
    public boolean removeEventInterceptor(WFEventInterceptor aInterc);
    
    /**
     * 注册事件处理器
     * @param eventType
     * @param aHandler
     */
    public void registeEventHandler(int eventType, WFEventHandler aHandler);
}



