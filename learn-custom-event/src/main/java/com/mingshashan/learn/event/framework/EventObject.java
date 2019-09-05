/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/EventObject.java,v 1.1 2013/10/11 17:30:01 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:01 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on 2007-7-31
 *******************************************************************************/


package com.mingshashan.learn.event.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author liuhang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: EventObject.java,v $
 * Revision 1.1  2013/10/11 17:30:01  haoyf
 * add: java 2 maven
 *
 * Revision 1.2  2013/09/04 13:34:30  wuyh
 * update:代码编码转换为UTF-8
 *
 * Revision 1.1  2013/08/23 11:38:24  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/22 13:00:00  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/21 10:51:27  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2009/06/24 07:56:45  haoyf
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
 * Revision 1.2  2007/08/30 02:18:56  haoyf
 * Update: 去掉无用的import
 *
 * Revision 1.1  2007/08/28 09:57:43  haoyf
 * Update：重构修改包名错误
 *
 * Revision 1.1  2007/08/23 01:19:28  liuhang
 * Update:refector based on the third gread model
 *
 * Revision 1.1  2007/08/09 09:22:26  liuxj
 * Add:迁移项目到EOS Studio中
 *
 * Revision 1.2  2007/08/09 04:30:07  liuhang
 * Update：remove hintevent id
 *
 * Revision 1.1  2007/07/31 12:07:41  liuhang
 * Update: 重构EVENT
 *
 */
public class EventObject {
    private long startDisposeTime;
    private long endDisposeTime;
    private Throwable throwable;
    private long eventID;
    private List<EventCallBack> eventCallbacks = null;//为了节省空间,可能为空

    public long getID() {
        return eventID;
    }

    public synchronized void addEventCallback(EventCallBack cb) {
        if (eventCallbacks == null) {
            eventCallbacks = new ArrayList<EventCallBack>();
        }
        eventCallbacks.add(cb);
    }

    public synchronized boolean removeEventCallback(EventCallBack cb) {
        if (eventCallbacks == null) return false;
        return eventCallbacks.remove(cb);
    }

    public void executeCallback() {
        if (eventCallbacks == null) {
            return;
        }
        for (EventCallBack cb : eventCallbacks) {
            if (this.throwable == null) {
                cb.executeCallbackSuccess(this);
            } else {
                cb.executeCallbackFail(this, this.throwable);
            }
        }
    }

    /**
     * @return Returns the endDisposeTime.
     */
    public long getEndDisposeTime() {
        return endDisposeTime;
    }

    /**
     * end event
     */
    public void endEvent() {
        this.endDisposeTime = System.currentTimeMillis();
        this.executeCallback();
    }

    /**
     * @return Returns the startDisposeTime.
     */
    public long getStartDisposeTime() {
        return startDisposeTime;
    }

    /**
     * begin event
     */
    public void beginEvent() {
        this.startDisposeTime = System.currentTimeMillis();
    }

    /**
     * @return Returns the throwable.
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * @param throwable The throwable to set.
     */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }


}
