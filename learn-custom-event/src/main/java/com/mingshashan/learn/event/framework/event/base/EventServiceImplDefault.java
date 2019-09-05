/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/event/base/EventServiceImplDefault.java,v 1.1 2013/10/11 17:30:41 haoyf Exp $
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

import com.eos.infra.config.Configuration.Group;
import com.mingshashan.learn.event.exception.EventException;
import com.mingshashan.learn.event.framework.Event;
import com.mingshashan.learn.event.framework.EventServiceInterceptor;
import com.mingshashan.learn.event.framework.IEventService;
import com.mingshashan.learn.event.framework.event.base.interceptor.EventRunnerInterceptor;
import com.mingshashan.learn.event.framework.load.EventHandlerLoader;

/**
 * TODO此处填写 class 信息
 *
 * @author liuhang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: EventServiceImplDefault.java,v $
 * Revision 1.1  2013/10/11 17:30:41  haoyf
 * add: java 2 maven
 *
 * Revision 1.2  2013/09/04 13:34:55  wuyh
 * update:代码编码转换为UTF-8
 *
 * Revision 1.1  2013/08/23 11:38:13  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/22 13:00:03  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/21 10:51:30  wuyh
 * update:代码迁移 PTP5.0
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
 * Revision 1.1  2008/11/11 05:00:21  liuxj
 * Add:项目改名，包名重命名
 *
 * Revision 1.9  2008/11/05 05:40:43  haoyf
 * update:还原
 *
 * Revision 1.8  2008/11/05 05:37:54  haoyf
 * update:还原
 *
 * Revision 1.7  2008/11/05 02:58:14  haoyf
 * add:增加创建流程实例的Event，在eventService的拦截器链上实现了事务和锁的控制
 *
 * Revision 1.6  2008/10/20 02:00:03  liuxj
 * Update:去掉无用导入类
 *
 * Revision 1.5  2008/10/15 06:36:23  liuxj
 * Update:继承EventServiceInterceptor
 *
 * Revision 1.2  2008/09/24 02:22:15  hucc
 * Refactor the IEventService to extend on Service interface.
 *
 * Revision 1.1  2008/09/22 03:29:42  liuxj
 * Add:项目拆分
 *
 * Revision 1.4  2007/09/12 08:34:25  liuxj
 * Remove:移动WFException类到com.primeton.workflow.api.exception包中
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
 * Revision 1.1  2007/05/16 12:24:13  liuhang
 * Add:share project
 *
 * Revision 1.3  2006/11/24 02:39:11  zhangyue
 * 同步
 *
 * Revision 1.1.2.3  2006/11/09 07:52:55  liuhang
 * add aop patten to event service
 * add lock service
 *
 * Revision 1.1.2.2  2006/08/24 09:09:05  liuhang
 * modify event strategy
 *
 * Revision 1.1.2.1  2006/08/24 06:18:23  liuhang
 * add to cvs
 *
 */

public class EventServiceImplDefault extends EventServiceInterceptor implements IEventService {

    /*
     * 此处后续需要重构，不应该使得EventServiceImplDefault 继承 EventServiceInterceptor
     */

    private String serviceName;
    private int startupIndex = Integer.MAX_VALUE;

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getStartupIndex() {
        return this.startupIndex;
    }

    public void setStartupIndex(int index) {
        this.startupIndex = index;
    }

    @Override
    public void config(Group[] group) {

    }

    /**
     * 初始化Event Service.
     * <p>
     * 主要是加载Event和Event Handler配置.
     */
    @Override
    public void init() {
        EventHandlerLoader.load();
    }

    /**
     * 启动Service.
     * <p>
     * 注册相应的Interceptor(). 以后此处会移到contribution group中配置化加载.
     */
    @Override
    public void start() {
//		addIntercepror(new TransactionEventServiceInterceptor());
//		addIntercepror(new LockEventServiceInterceptor());
        addIntercepror(new EventRunnerInterceptor());
    }

    /**
     * 停止Service.
     */
    public void stop() {
    }


    @Override
    public void publish(Event event) throws EventException {
        super.invoke(event);
    }

    @Override
    public EventServiceInterceptor getServiceChain() {
        return this;
    }

    @Override
    public void addIntercepror(EventServiceInterceptor esi) {
        EventServiceInterceptor curEsi = this;
        while (curEsi.getNext() != null) {
            curEsi = curEsi.getNext();
        }
        curEsi.setNext(esi);
    }

    public void insertIntercepror(EventServiceInterceptor esi) {
        EventServiceInterceptor next = this.getNext();
        esi.setNext(next);
        this.setNext(esi);
    }

    @Override
    public Class getServiceInterface() {
        return IEventService.class;
    }


//    public void publishCloseException(Event event) {
//        throw new RuntimeException("not impl");
//    }
//
//    public void processEvent(Event event) throws WFException {
//        throw new RuntimeException("not impl");
//    }
}



