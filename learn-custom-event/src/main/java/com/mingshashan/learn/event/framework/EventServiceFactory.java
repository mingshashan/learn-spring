package com.mingshashan.learn.event.framework;

/**
 * 此类主要是为了提高效率，能够快速索引EventService实例.
 *
 */
public class EventServiceFactory {

	private static IEventService service = (IEventService)WFServiceFactory.getService("EventService");
	
	public static IEventService getEventService(){
		return service;
	}
	
}
