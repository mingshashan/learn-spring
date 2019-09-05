package com.mingshashan.learn.event.framework;

/**
 * 本地的WFEventContext管理，为每一个线程管理一个WFEventContext
 */
public class LocalEventCtxManager {

    private static ThreadLocal localCtx = new ThreadLocal();

    public static EventContext getCurrentEventContext() {
        return (EventContext) localCtx.get();
    }

    public static void setCurrentEventContext(EventContext ctx) {
        localCtx.set(ctx);
    }
}
