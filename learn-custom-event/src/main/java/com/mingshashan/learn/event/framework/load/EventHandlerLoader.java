package com.mingshashan.learn.event.framework.load;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.eos.system.utility.ClassUtil;
import com.primeton.workflow.commons.utility.XML;
import com.primeton.workflow.commons.utility.XMLException;
import com.primeton.workflow.event.framework.WFEventHandler;

public class EventHandlerLoader {

	private static Map<String, WFEventHandler[]> eventHandlersMap = new HashMap<String,WFEventHandler[]>();
	private static Map<String,WFEventHandler> handlersMap = new HashMap<String,WFEventHandler>();
	
	public static void load(){

		try {
			Document doc = XML.parseStreamWithEncode(EventHandlerLoader.class, "event_config.xml", "utf-8");
			
			NodeList eventHandlersNode = XML.findNodeList(doc.getDocumentElement(), "handlers/handler");
			for (int i = 0; i < eventHandlersNode.getLength(); i++) {
				Element node = (Element)eventHandlersNode.item(i);
				String handler_alias = node.getAttribute("alias");
				String handler_class = node.getAttribute("class");
				WFEventHandler handler = (WFEventHandler)getInstance(handler_class);
				handlersMap.put(handler_alias, handler);
			}
			
			NodeList nodes = XML.findNodeList(doc.getDocumentElement(), "events/event");
			for (int i = 0; i < nodes.getLength(); i++) {
				Element node = (Element)nodes.item(i);
				String eventType = node.getAttribute("type");
				
				if(node instanceof Element){
					NodeList handlerNodes = XML.findNodeList((Element)node, "handler");
					List<WFEventHandler> handlerList = new ArrayList<WFEventHandler>();
					for (int j = 0; j < handlerNodes.getLength(); j++) {
						Element handlerNode = (Element)handlerNodes.item(j);
						
						String handler_alias = handlerNode.getAttribute("alias");
						WFEventHandler handler = null;
						if(!(handler_alias==null || handler_alias.length()==0)){
							handler = handlersMap.get(handler_alias);
						}else{
							String handlerClassName = handlerNode.getAttribute("class");
							handler = (WFEventHandler)getInstance(handlerClassName);
						}
						handlerList.add(handler);
					}
					eventHandlersMap.put(eventType, handlerList.toArray(new WFEventHandler[0]));
					
				}
				
			}
			
		} catch (XMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void registerWFEventHandler(String type,WFEventHandler eventHandler){
		WFEventHandler[] value=new WFEventHandler[]{eventHandler};
		eventHandlersMap.put(type, value);
	}
	
	
	
	public static WFEventHandler[] getWFEventHandlers(String type){
		return eventHandlersMap.get(type);
	}	
	
	private static Object getInstance(String classname){
		try {
			return ClassUtil.newInstance(classname, null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LinkageError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	
}
