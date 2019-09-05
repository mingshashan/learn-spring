/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/event/base/WFEventExecutor.java,v 1.1 2013/10/11 17:30:41 haoyf Exp $
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

import com.mingshashan.learn.event.exception.EventException;
import com.primeton.workflow.commons.logging.LogService;
import com.primeton.workflow.commons.logging.impl.WFTraceLogger;
import com.primeton.workflow.event.framework.WFEvent;
import com.primeton.workflow.event.framework.WFEventHandler;
import com.primeton.workflow.event.framework.WFEventInterceptor;
import com.primeton.workflow.event.framework.load.EventHandlerLoader;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


/**
 * TODO此处填写 class 信息
 *
 * @author liuhang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: WFEventExecutor.java,v $
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
 * Revision 1.1  2009/06/24 07:56:44  haoyf
 * add:move cvs
 *
 * Revision 1.2  2009/04/21 03:48:29  litw
 * *** empty log message ***
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
 * Revision 1.3  2008/10/15 06:37:23  liuxj
 * Update:修改handleEvent方法，注释掉handlerMap变量
 *
 * Revision 1.2  2008/09/24 02:51:17  hucc
 * Edit WFEventExecutor to get eventhandler from EventHandlerLoader
 *
 * Revision 1.1  2008/09/22 03:29:42  liuxj
 * Add:项目拆分
 *
 * Revision 1.5  2007/11/09 02:14:58  haoyf
 * Update:松耦合重构
 *
 * Revision 1.4  2007/09/12 08:34:25  liuxj
 * Remove:移动EventException类到com.primeton.workflow.api.exception包中
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
 * Revision 1.1.2.8  2006/11/21 09:52:46  liuhang
 * UnitTest:修复bl方法返回不正确的问题
 *
 * Revision 1.1.2.7  2006/11/18 05:27:41  liuhang
 * add debug info
 *
 * Revision 1.1.2.6  2006/11/10 06:09:56  liuhang
 * 主要是增加异常的记录
 *
 * Revision 1.1.2.5  2006/11/08 09:56:42  liuhang
 * log exception
 *
 * Revision 1.1.2.4  2006/09/27 06:48:14  liuhang
 * print event info when exception
 *
 * Revision 1.1.2.3  2006/09/14 07:00:52  liuhang
 * 修改EVENT，传递实例,使用InstancePool,以及EventContext
 *
 * Revision 1.1.2.2  2006/08/24 09:09:05  liuhang
 * modify event strategy
 *
 * Revision 1.1.2.1  2006/08/24 06:18:23  liuhang
 * add to cvs
 *
 * Revision 1.1.2.3  2006/08/23 09:55:24  liuhang
 * UnitTest:modify to : while(targetCtx.moveToNextEvent());
 *
 * Revision 1.1.2.2  2006/08/23 09:34:39  liuhang
 * add setConcreateClass method
 *
 * Revision 1.1.2.1  2006/08/23 07:00:46  liuhang
 * UnitTest:修复了addEventCtx的错误
 *
 */

public final class WFEventExecutor {
    private WFTraceLogger logger = WFTraceLogger.getWFTraceLogger(WFEventExecutor.class);
    Hashtable handlerMap = new Hashtable();
    List interceptors = new ArrayList();

    /**
     * 处理事件,this method can't throw exception
     *
     * @param event
     * @throws EventException
     */
    public void handleEvent(WFEvent event) throws EventException {
        try {
            for (int i = 0; i < interceptors.size(); i++) {
                if (!((WFEventInterceptor) interceptors.get(i)).beforeExecute(event)) return;
            }
        } catch (Throwable e) {
            logger.log(LogService.LEVEL_ERROR, "exec before Execute Exception ", e);
            e.printStackTrace();
        }

        //execute it ,catch Throwable
        try {
//            if (!handlerMap.containsKey(String.valueOf(event.getType()))) {
//                throw new RuntimeException("can't find the handler for eventtype:"
//                        + event.getType());
//            }
            //WFEventHandler hand = (WFEventHandler) handlerMap.get(String.valueOf(event.getType()));

            //暂时只支持一个Handler，后续需要调整策略.
            WFEventHandler hand = EventHandlerLoader.getWFEventHandlers(String.valueOf(event.getType()))[0];
            hand.invoke(event);
        } catch (Throwable t) {
            event.setThrowable(t);

            StringBuffer sb = new StringBuffer();
            sb.append("  EVENT={");
            sb.append(event);
            sb.append("}");
            sb.append("  EVENTCONTEXT={");
            sb.append(event.getOwnerEventCtx());
            sb.append("}");

            //汇报异常
            event.getOwnerEventCtx().addExceptionToRootContext(t);
            t.printStackTrace();
            logger.log(LogService.LEVEL_ERROR, "exec event exception " + sb.toString(), t);
        }

        try {
            for (int i = 0; i < interceptors.size(); i++) {
                ((WFEventInterceptor) interceptors.get(i)).afterExecute(event);
            }
        } catch (Throwable e) {
            logger.log(LogService.LEVEL_ERROR, "exec afterExecute Exception ", e);
            e.printStackTrace();
        }
    }


    /*
     * (non-Javadoc)
     *
     * @see com.primeton.eos5.wf.service.EventService#registe(com.primeton.eos5.wf.EventHandler)
     */
    @SuppressWarnings("unchecked")
    public void registe(int eventType, WFEventHandler eventHandler) {
        if (handlerMap.containsKey(String.valueOf(eventType))) {
            System.out.println("Warnning : eventType " + eventType
                    + "  is registe a second time");
        }
        EventHandlerLoader.registerWFEventHandler(String.valueOf(eventType), eventHandler);
        handlerMap.put(String.valueOf(eventType), eventHandler);
    }

    /**
     * add a interceptor
     *
     * @param aInterceptor
     */
    @SuppressWarnings("unchecked")
    public void registeInterceptor(WFEventInterceptor aInterceptor) {
        if (this.interceptors.contains(aInterceptor)) return;
        interceptors.add(aInterceptor);
    }

    /**
     * remove a interceptor
     *
     * @param aInterceptor
     * @return true: remove successfully    false:can't find the interceptor
     */
    public boolean removeInterceptor(WFEventInterceptor aInterceptor) {
        return interceptors.remove(aInterceptor);
    }
}
