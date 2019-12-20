package com.mingshashan.learn.event.framework;

import com.mingshashan.learn.event.exception.EventException;

public interface WFEventInterceptor {
    /**
     * before execute
     *
     * @param event
     * @return true:continue to dispose ; false:stop to dispose
     */
    boolean beforeExecute(Event event);

    /**
     * after execute
     * @param event event disposed
     * @throws EventException
     */
    void afterExecute(Event event) throws EventException;

}



