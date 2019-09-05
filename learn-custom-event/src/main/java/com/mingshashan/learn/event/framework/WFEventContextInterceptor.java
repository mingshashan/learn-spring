
package com.mingshashan.learn.event.framework;

public interface WFEventContextInterceptor {
    /**
     * before execute
     *
     * @param eventContext
     * @return true:continue to dispose ; false:stop to dispose
     */
    boolean beforeExecute(EventContext eventContext);

    /**
     * after execute
     *
     * @param eventContext ctx disposed
     * @param throwable   the exception may be null
     * @return
     */
    void afterExecute(EventContext eventContext, Throwable throwable);
}



