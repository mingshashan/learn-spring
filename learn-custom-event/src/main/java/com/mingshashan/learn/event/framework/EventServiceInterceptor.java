/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/EventServiceInterceptor.java,v 1.1 2013/10/11 17:30:01 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:01 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2004 Primeton Technologies, Ltd.
 * All rights reserved. 
 *
 * Created on 2006-11-9
 *******************************************************************************/

package com.mingshashan.learn.event.framework;


public class EventServiceInterceptor extends AbstractService {
    private EventServiceInterceptor next;

    public Object invoke(Event event) throws WFException {
        if (next == null) return null;
        else return next.invoke(event);
    }

    public void setNext(EventServiceInterceptor next) {
        this.next = next;
    }

    public EventServiceInterceptor getNext() {
        return this.next;
    }

    public void config(Group[] group) {
        // TODO Auto-generated method stub

    }

    public Class getServiceInterface() {
        // TODO Auto-generated method stub
        return null;
    }

    public void init() {
        // TODO Auto-generated method stub

    }

    public void start() {
        // TODO Auto-generated method stub

    }
}



