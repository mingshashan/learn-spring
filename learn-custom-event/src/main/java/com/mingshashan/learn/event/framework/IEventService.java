/*
 * Created on 2004-7-24
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.mingshashan.learn.event.framework;


/**
 * IEventService代表一个事件处理的接口。所有事件在其内部可以采用同步处理
 * 的方式，也可以采用异步处理的方式，目前采用同步处理的方式。
 */

import com.mingshashan.learn.event.exception.EventException;

public interface IEventService {

    /**
     * 发布事件
     *
     * @param event
     */
    public void publish(Event event) throws EventException;

    /**
     * get service chain
     *
     * @return
     */
    public EventServiceInterceptor getServiceChain();

    /**
     * add interceptor
     *
     * @param esi
     */
    public void addInterceptor(EventServiceInterceptor esi);

    /**
     * 关闭异常，发布事件
     *
     * @param event
     */
    public void publishCloseException(Event event);

    /**
     * 同步调用该事件
     *
     * @param event
     * @throws EventException
     */
    public void processEvent(Event event) throws EventException;

}
