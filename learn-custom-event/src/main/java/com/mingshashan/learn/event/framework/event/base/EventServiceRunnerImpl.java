/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/event/base/EventServiceRunnerImpl.java,v 1.1 2013/10/11 17:30:41 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:41 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2004 Primeton Technologies, Ltd.
 * All rights reserved. 
 * 
 * Created on 2006-8-23
 *******************************************************************************/

package com.mingshashan.learn.event.framework.event.base;

import java.util.ArrayList;
import java.util.List;

import com.mingshashan.learn.event.framework.IEventRunner;
import com.primeton.workflow.commons.logging.LogService;
import com.primeton.workflow.commons.logging.impl.WFTraceLogger;
import com.primeton.workflow.event.framework.IEventRunner;
import com.primeton.workflow.event.framework.LocalEventCtxManager;
import com.primeton.workflow.event.framework.WFEvent;
import com.primeton.workflow.event.framework.WFEventContext;
import com.primeton.workflow.event.framework.WFEventContextInterceptor;
import com.primeton.workflow.event.framework.WFEventHandler;
import com.primeton.workflow.event.framework.WFEventInterceptor;

/**
 * TODO此处填写 class 信息
 *
 * @author liuhang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: EventServiceRunnerImpl.java,v $
 * Revision 1.1  2013/10/11 17:30:41  haoyf
 * add: java 2 maven
 *
 * Revision 1.2  2013/09/04 13:34:55  wuyh
 * update:代码编码转换为UTF-8
 *
 * Revision 1.1  2013/08/23 11:38:13  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/22 13:00:04  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/21 10:51:30  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.2  2011/10/28 09:53:01  tenghao
 * Update Fix Bug 34551 使用startProcessInstAndFinishFirstWorkItem方法时，启动后续活动失败，异常被捕获未能抛出。
 *
 * Revision 1.1  2009/06/24 07:56:44  haoyf
 * add:move cvs
 *
 * Revision 1.1  2009/04/02 07:14:34  haoyf
 * add:新项目迁移到主干
 *
 * Revision 1.1  2008/11/14 07:52:05  liuxj
 * Add:项目重命名，包命名
 *
 * Revision 1.2  2008/11/11 08:22:00  hucc
 * change logging package
 *
 * Revision 1.1  2008/11/11 05:00:21  liuxj
 * Add:项目改名，包名重命名
 *
 * Revision 1.1  2008/09/22 03:29:42  liuxj
 * Add:项目拆分
 *
 * Revision 1.3  2007/08/30 02:20:37  haoyf
 * Update: 去掉无用的import
 *
 * Revision 1.2  2007/08/28 09:57:17  haoyf
 * Update：重构修改包名错误
 *
 * Revision 1.1  2007/08/23 01:19:29  liuhang
 * Update:refector based on the third gread model
 *
 * Revision 1.1  2007/08/09 09:22:29  liuxj
 * Add:迁移项目到EOS Studio中
 *
 * Revision 1.4  2007/08/09 04:24:10  liuhang
 * Update:增加事务分段属性的传播
 *
 * Revision 1.3  2007/07/27 08:14:20  liuxj
 * Update:更新
 *
 * Revision 1.2  2007/07/16 06:21:19  liuxj
 * Update:更新日志记录方式
 * Update:更新数据库主键常量获取方式,和主键生成的方法调用的修改
 *
 * Revision 1.1  2007/05/16 12:24:13  liuhang
 * Add:share project
 *
 * Revision 1.3  2006/11/24 02:39:11  zhangyue
 * 同步
 *
 * Revision 1.1.2.7  2006/11/10 06:09:56  liuhang
 * 主要是增加异常的记录
 *
 * Revision 1.1.2.6  2006/11/09 07:52:55  liuhang
 * add aop patten to event service
 * add lock service
 *
 * Revision 1.1.2.5  2006/08/24 09:09:05  liuhang
 * modify event strategy
 *
 * Revision 1.1.2.4  2006/08/24 06:18:23  liuhang
 * add to cvs
 *
 * Revision 1.1.2.3  2006/08/23 10:00:01  liuhang
 * UnitTest:add LocalEventCtxManager.setCurrentEventContext(targetCtx);!
 *
 * Revision 1.1.2.2  2006/08/23 09:56:58  liuhang
 * UnitTest:修改为targetCtx.getParent() != null
 *
 * Revision 1.1.2.1  2006/08/23 08:48:07  liuhang
 * 重构EVENT　API
 * 
 */

public class EventServiceRunnerImpl implements IEventRunner {
	private WFTraceLogger logger = WFTraceLogger.getWFTraceLogger(EventServiceRunnerImpl.class);
    WFEventExecutor eventExecutor = new WFEventExecutor();
    List ctxInterceptors = new ArrayList();
    
    /**
     * 或者在当前增加一个事件，或者处理完毕这个事件（当前正在事件处理逻辑中，稍后处理）
     */
    public void addOrProcessEvent(WFEvent event) {
        WFEventContext currCtx = LocalEventCtxManager.getCurrentEventContext();
        if ( currCtx == null||currCtx.isStopped()){
            process(event);
        }else{
            currCtx.addEvent(event);
        }
    }
    
    /**
     * 如果创建了一个根EventContext，则把EVENT的UseTxSegment属性传递给EventContext
     * 如果创建了一个child Context,则把父CONTEXT的 UseTxSegment属性 传递给子 EventContext
     */
    
    public void process(WFEvent event){
        WFEventContext currCtx = LocalEventCtxManager.getCurrentEventContext();
        WFEventContext targetCtx;
        if ( currCtx == null){
            //create new
            targetCtx = new WFEventContext();
            targetCtx.setUseTxSegment(event.isUseTxSegment());//
        }else if (currCtx.isStopped()){
            //clear and reuse
            currCtx.clear();
            targetCtx = currCtx;            
            targetCtx.setUseTxSegment(event.isUseTxSegment());//
        }else{
            //add sub context
            WFEvent currEvent = currCtx.getCurrentEvent();
            WFEventContext childCtx = currEvent.addChildContext();
            targetCtx = childCtx;
            childCtx.setUseTxSegment(currCtx.isUseTxSegment());//
        }
        targetCtx.addEvent(event);
        
        processOneContextSafe(targetCtx);
        
        WFEventContext ownerEventCtx = event.getOwnerEventCtx();
 	 	List exceptionList = ownerEventCtx.getExceptionList();
 	 	if (exceptionList!=null && exceptionList.size()>0){
 	 		Throwable th0 = (Throwable) exceptionList.get(0);
 	 		throw new RuntimeException(th0);
 	 	}
    }

    
    /**
     * 确保在Current Context要么被完全处理，要么设置为null.
     * 避免出现“留下一个完成一半的Context”的严重问题。
     * @param targetCtx
     */
    private void processOneContextSafe(WFEventContext targetCtx) {
        try{
            LocalEventCtxManager.setCurrentEventContext(targetCtx);
            // process target ctx
            processOneContext(targetCtx);
            // set to parent
            if (targetCtx.getParent() != null){
                LocalEventCtxManager.setCurrentEventContext(targetCtx.getParent().getOwnerEventCtx());
            }
        }catch(Throwable th){
            LocalEventCtxManager.setCurrentEventContext(null);
            System.out.println("!This is a fatal error! exceptin when process one context, the current ctx is set to null!");
            th.printStackTrace();
            logger.log(LogService.LEVEL_ERROR,"",th);
        }
    }

    private void processOneContext(WFEventContext targetCtx) {
        //exec before handler
        try{
            for (int i=0;i<this.ctxInterceptors.size();i++)
                if (!((WFEventContextInterceptor)this.ctxInterceptors.get(i)).beforeExecute(targetCtx))
                    return;
        }catch(Throwable th){
            th.printStackTrace();
            logger.log(LogService.LEVEL_ERROR,"",th);
        }
        
        do{
            WFEvent eventToDispose = targetCtx.getCurrentEvent();
            try{
                eventExecutor.handleEvent(eventToDispose);//应该不会抛出异常
            }catch(Throwable e){
                e.printStackTrace();
                logger.log(LogService.LEVEL_ERROR,"Fatal Error!!!,exception shoudln't throw herre",e);
            }
        }while(targetCtx.moveToNextEvent());
        
        //exec after handler
        try{
            for (int i=0;i<this.ctxInterceptors.size();i++){
                ((WFEventContextInterceptor)this.ctxInterceptors.get(i)).afterExecute(targetCtx,null);
            }
        }catch(Throwable th){
            th.printStackTrace();
            logger.log(LogService.LEVEL_ERROR,"",th);
        }
    }

    @SuppressWarnings("unchecked")
	public void registeEventCtxInterceptor(WFEventContextInterceptor aInterc) {
        if (this.ctxInterceptors.contains(aInterc)) return;
        this.ctxInterceptors.add(aInterc);
    }

    public boolean removeEventCtxInterceptor(WFEventContextInterceptor aInterc) {
        return this.ctxInterceptors.remove(aInterc);
    }

    public void registeEventInterceptor(WFEventInterceptor aInterc) {
        eventExecutor.registeInterceptor(aInterc);
    }

    public boolean removeEventInterceptor(WFEventInterceptor aInterc) {
        return eventExecutor.removeInterceptor(aInterc);
    }

    public void registeEventHandler(int eventType, WFEventHandler aHandler) {
        this.eventExecutor.registe(eventType,aHandler);
    }
}



