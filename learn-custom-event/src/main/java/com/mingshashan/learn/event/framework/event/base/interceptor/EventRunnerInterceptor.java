/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/event/base/interceptor/EventRunnerInterceptor.java,v 1.1 2013/10/11 17:30:17 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:17 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2004 Primeton Technologies, Ltd.
 * All rights reserved. 
 *
 * Created on 2006-11-9
 *******************************************************************************/

package com.mingshashan.learn.event.framework.event.base.interceptor;

import com.mingshashan.learn.event.framework.Event;
import com.mingshashan.learn.event.framework.EventServiceInterceptor;
import com.mingshashan.learn.event.framework.IEventRunner;
import org.w3c.dom.events.EventException;

import java.util.List;

/**
 * TODO此处填写 class 信息
 *
 * @author liuhang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: EventRunnerInterceptor.java,v $
 * Revision 1.1  2013/10/11 17:30:17  haoyf
 * add: java 2 maven
 *
 * Revision 1.2  2013/09/04 13:35:05  wuyh
 * update:代码编码转换为UTF-8
 *
 * Revision 1.1  2013/08/23 11:38:38  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/22 13:00:25  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/21 10:51:58  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2009/06/24 07:56:49  haoyf
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
 * Revision 1.1  2008/09/22 03:29:42  liuxj
 * Add:项目拆分
 *
 * Revision 1.3  2007/09/12 08:34:24  liuxj
 * Remove:移动WFException类到com.primeton.workflow.api.exception包中
 *
 * Revision 1.2  2007/08/28 09:57:17  haoyf
 * Update：重构修改包名错误
 *
 * Revision 1.1  2007/08/23 01:19:30  liuhang
 * Update:refector based on the third gread model
 *
 * Revision 1.1  2007/08/09 09:22:29  liuxj
 * Add:迁移项目到EOS Studio中
 *
 * Revision 1.1  2007/05/16 12:24:13  liuhang
 * Add:share project
 *
 * Revision 1.2  2006/11/24 02:39:24  zhangyue
 * 同步
 *
 * Revision 1.1.2.2  2006/11/21 09:52:46  liuhang
 * UnitTest:修复bl方法返回不正确的问题
 *
 * Revision 1.1.2.1  2006/11/09 07:52:54  liuhang
 * add aop patten to event service
 * add lock service
 *
 */

public class EventRunnerInterceptor extends EventServiceInterceptor {

    @Override
    public Object invoke(Event event) throws EventException {
        IEventRunner.INSTANCE.process(event);
        List exList = event.getOwnerEventCtx().getExceptionList();
        if (exList == null || exList.size() == 0) {
            return super.invoke(event);
        } else {
            Throwable th0 = (Throwable) exList.get(0);
            if (th0 instanceof EventException) {
                throw (EventException) th0;
            } else {
                throw new RuntimeException(th0);
            }
        }
    }
}



