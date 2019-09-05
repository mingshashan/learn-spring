/*
 * Created on 2004-10-31
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.mingshashan.learn.event.framework.event;

import com.mingshashan.learn.event.framework.Event;
import com.primeton.workflow.event.framework.WFEvent;
import com.primeton.workflow.service.das.exception.DataAccessException;
import com.primeton.workflow.service.das.model.entities.WFActivityInstInternal;

/**
 * @author LiuHang
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
class WFEventFactoryHelp {
    /**
     * 填充event的相关字段。
     * if workitemid!=0 填充actInstID procInstID procDefID
     * else if actinstid!=0 填充procInstID procDefID
     * else if procInstID!=0 填充procDefID
     * @param event
     * @throws DataAccessException
     */
    public static void fillEventFields(Event event) {
        //只有processDefID,acDefID可能需要fill
        if (event.getProcInstID() > 0 || event.getProcInstID() < -1) {
            if (event.getProcessDefID() <= 0) {
                event.setProcessDefID(event.getProcessInstance()
                        .getProcessDefID());

                if (event.getActInstID() > 0) {
                    String adefid = event.getActDefID();
                    if (adefid == null || adefid.equals("")) {
                    	WFActivityInstInternal activityInstance = event.getActivityInstance();
                        if(null != activityInstance)
                        	event.setActDefID(activityInstance.getActivityDefID());
                    }
                }
            }
        }
    }
}

//		try{
//			DataAccessService das = WFServiceFactory.getService(DataAccessService.class);
//			if (event.getWorkItemID()!=0){
//				if (event.getActInstID()==0){
//					WFWorkItem wi = das.findWorkItemByID(event.getWorkItemID());
//					event.setActInstID(wi.getActivityInstID());
//				}
//			}
//			
//			if (event.getActInstID()!=0){
//				if (event.getProcInstID()==0 || StringUtil.isNull(event.getActDefID())){
//					WFActivityInstance actInst = das.findActivityInstanceByID(event.getActInstID());
//					if (event.getProcInstID()==0) event.setProcInstID(actInst.getProcessInstID());
//					if (StringUtil.isNull(event.getActDefID())) event.setActDefID(actInst.getActivityDefID());
//				}
//			}
//			
//			if (event.getProcInstID()!=0){
//				if (event.getProcessDefID()==0){
//					WFProcessInstance pi = das.findProcessInstanceByID(event.getProcInstID());
//					event.setProcessDefID(pi.getProcessDefID());
//				}
//			}
//		}catch(DataAccessException e){
//			e.printStackTrace();
//			WFLogger.log(WFEventFactoryHelp.class,WFLogger.LEVEL_FATAL,"DataAccessService While fill event fields!",e);
//		}catch(Exception e){
//			e.printStackTrace();
//			WFLogger.log(WFEventFactoryHelp.class,WFLogger.LEVEL_FATAL,"Exception While fill event fields!",e);
//		}

