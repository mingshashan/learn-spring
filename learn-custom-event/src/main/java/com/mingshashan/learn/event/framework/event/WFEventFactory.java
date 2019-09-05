/*
 * Created on 2004-8-8
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.mingshashan.learn.event.framework.event;


import com.primeton.workflow.event.framework.WFEvent;
import com.primeton.workflow.model.engine.WFPrivateInfo;
import com.primeton.workflow.model.task.TaskOption;
import com.primeton.workflow.service.das.model.entities.WFProcessInstInternal;
import com.primeton.workflow.service.das.model.entities.WFWorkItemInternal;

/**
 * @author LiuHang
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class WFEventFactory {
    /*
     * this.registe(WFEventType.START_PROCESS,ps);
     * this.registe(WFEventType.SCHEDULE_NEXT_ACTIVITY,ps);
     * this.registe(WFEventType.BACKWORD_ACTIVITY,ps);
     * this.registe(WFEventType.SUSPEND_PROCESS,ps);
     * this.registe(WFEventType.RESUME_PROCESS,ps);
     * this.registe(WFEventType.CHANGE_PROCESS_STATE,ps);
     * this.registe(WFEventType.TERMINATE_PROCESS,ps);
     * this.registe(WFEventType.ABORT_PROCESS,ps);
     */
	
    public static WFEvent createSTART_PROCESSEvent(long procInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.START_PROCESS,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    /**
     * @param activityInstID
     */
    public static WFEvent createScheduleNextActivityEvent(long procDefID,
            long procInstID, String actDefID, long activityInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.SCHEDULE_NEXT_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(procDefID);
        event.setProcInstID(procInstID);
        event.setActDefID(actDefID);
        event.setActInstID(activityInstID);
        event.setProcessInstance(procInst);
        
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    /**
     * @param id
     * @param procInstID
     * @param aid
     * @return
     */
    public static WFEvent createStartActivityEvent(long procDefID,
            long procInstID, String aDefID, long aInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.START_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(procDefID);
        event.setProcInstID(procInstID);
        event.setActDefID(aDefID);
        event.setActInstID(aInstID);
        event.setProcessInstance(procInst);
        
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    
    /**
     * add in V51
     * @param id
     * @param procInstID
     * @param aid
     * @return
     */
    public static WFEvent createPreStartActivityEvent(long procDefID,
            long procInstID, String aDefID, long aInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.PRESTART_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(procDefID);
        event.setProcInstID(procInstID);
        event.setActDefID(aDefID);
        event.setActInstID(aInstID);
        event.setProcessInstance(procInst);
        
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    
    
    /**
     * @param processDefID
     * @param procInstID
     * @return
     */
    public static WFEvent createFinishProcessEvent(long processDefID,
            long procInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.FINISH_PROCESS,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);
        
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    public static WFEvent createSuspendProcessEvent(long procInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.SUSPEND_PROCESS,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);
        
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    public static WFEvent createResumeProcessEvent(long procInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.RESUME_PROCESS,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    /**
     * @param defid
     * @param processInstID
     * @return
     */
    public static WFEvent createStartProcessEvent(long defid, long processInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.START_PROCESS,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(defid);
        event.setProcInstID(processInstID);
        event.setProcessInstance(procInst);
        
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    /**
     * @param actInstID
     * @return
     */
    public static WFEvent createFinishActivityEvent(long procInstID,long actInstID,WFPrivateInfo pi,long hintEventID,boolean isTerminateWorkitem,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.FINISH_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        
        event.setContext(new Boolean(isTerminateWorkitem));
        
        event.setActInstID(actInstID);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);
        

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }
    
    
    public static WFEvent createSuspendActivityEvent(long procInstID,long actInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.SUSPEND_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setActInstID(actInstID);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    
    public static WFEvent createResumeActivityEvent(long procInstID,long actInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.RESUME_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setActInstID(actInstID);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);
        

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    
    /**
     * @param processDefID
     * @param processInstID
     * @param activityDefID
     * @param activityInstID
     * @return
     */
    public static WFEvent createTerminateActivityEvent(long processDefID,
            long processInstID, String activityDefID, long activityInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.TERMINATE_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setActDefID(activityDefID);
        event.setActInstID(activityInstID);
        event.setProcessInstance(procInst);
        

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    /**
     * 变更活动实例状态事件
     * @param processDefID
     * @param processInstID
     * @param activityDefID
     * @param activityInstID
     * @param pi
     * @param hintEventID
     * @param procInst
     * @param destState
     * @return
     */
    public static WFEvent createChangeActivityInstStateEvent(long processDefID,
            long processInstID, String activityDefID, long activityInstID,
			WFPrivateInfo pi, long hintEventID, WFProcessInstInternal procInst,int destState) {
    	 WFEvent event = new WFEvent(WFEventType.CHANGE_ACTIVITY_STATE,pi,Thread.currentThread().getName(),hintEventID,procInst);
         event.setProcessDefID(processDefID);
         event.setProcInstID(processInstID);
         event.setActDefID(activityDefID);
         event.setActInstID(activityInstID);
         event.setProcessInstance(procInst);
         //设置附加参数，目标状态
         event.setContext(Integer.valueOf(destState));
         WFEventFactoryHelp.fillEventFields(event);
         return event;

	}

    /**
     * 变更流程实例状态
     * @param procInstID
     * @param pi
     * @param hintEventID
     * @param procInst
     * @param destState
     * @return
     */
    public static WFEvent createChangeProcessInstStateEvent(long procInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst,int destState) {
        WFEvent event = new WFEvent(WFEventType.CHANGE_PROCESS_STATE,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);
        //      设置附加参数，目标状态
    	event.setContext(Integer.valueOf(destState));
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }
    // about 和 terminate以后，均不做以后的流程判断

    /**
     * @param processDefID
     * @param processInstID
     * @param activityDefID
     * @param activityInstID
     * @return
     */
    public static WFEvent createAboutActivityEvent(long processDefID,
            long processInstID, String activityDefID, long activityInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.ABORT_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setActDefID(activityDefID);
        event.setActInstID(activityInstID);
        event.setProcessInstance(procInst);
        

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    /**
     * @param procInstID
     * @param actDefID
     * @param actInstID
     * @return
     */
    public static WFEvent createTerminateProcessEvent(long procInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.TERMINATE_PROCESS,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcInstID(procInstID);
        event.setProcessInstance(procInst);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }
    
    

    public static WFEvent createProcInstTimeOutEvent(long processDefID,
            long processInstID,
            Object context,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.EXCEPTION_PROC_TIMEOUT,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setContext(context);
        event.setProcessInstance(procInst);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }
    
    public static WFEvent createProcInstRemindEvent(long processDefID,
            long processInstID, 
            Object context,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.EXCEPTION_PROC_REMIND,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setContext(context);
        event.setProcessInstance(procInst);
        
        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }

    public static WFEvent createWorkItemTimeOutEvent(long processDefID,
            long processInstID, String activityDefID, long activityInstID,long workItemID,
            Object context,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.EXCEPTION_WI_TIMEOUT,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setActDefID(activityDefID);
        event.setActInstID(activityInstID);
        event.setWorkItemID(workItemID);
        event.setContext(context);
        event.setProcessInstance(procInst);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }
    public static WFEvent createWorkItemRemindEvent(long processDefID,
            long processInstID, String activityDefID, long activityInstID,long workItemID,
            Object context,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.EXCEPTION_WI_REMIND,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setActDefID(activityDefID);
        event.setActInstID(activityInstID);
        event.setWorkItemID(workItemID);
        event.setContext(context);
        event.setProcessInstance(procInst);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }


    public static WFEvent createBackWordActivityEvent(long processDefID,
            long processInstID, String activityDefID, long activityInstID,WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
//        Event event = new Event(WFEventType.BACKWORD_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID);
//        event.setProcessDefID(processDefID);
//        event.setProcInstID(processInstID);
//        event.setActDefID(activityDefID);
//        event.setActInstID(activityInstID);
//        
//
//        WFEventFactoryHelp.fillEventFields(event);
//        return event;
//        
        return createBackWordActivityEventEx(processDefID,processInstID,activityDefID,activityInstID,pi,null,RollbackConst.ROLL_BACK_STRY_ONE_STEP,hintEventID,procInst);
    }
    
    
    public static WFEvent createBackWordActivityEventEx(long processDefID,
            long processInstID, String activityDefID, long activityInstID,WFPrivateInfo pi,String destActDefID,String backStrategy, long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.BACKWORD_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setActDefID(activityDefID);
        event.setActInstID(activityInstID);
        event.setProcessInstance(procInst);
        
        WFEventBackActivityStrategy sty;
        if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_PATHBASED)){
        	sty=WFEventBackActivityStrategy.STRATEGY_PATH;
        }else if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_TIMEBASED)){
        	sty=WFEventBackActivityStrategy.STRATEGY_TIME;
        }else if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_SIMPLE)){
        	sty=WFEventBackActivityStrategy.STRATEGY_SIMPLE;
        }else if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_RECENT_MANUAL)){
        	sty=WFEventBackActivityStrategy.STRATEGY_RECENT_MANUAL;
        }else{
        	sty = WFEventBackActivityStrategy.STRATEGY_ONESTEP;
        }
        
        WFEventBackActivityParameter para = new WFEventBackActivityParameter(sty,destActDefID,0);
        event.setContext(para);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }
    
    public static WFEvent createBackWordActivityEventEx(long processDefID,
            long processInstID, String activityDefID, long activityInstID,WFPrivateInfo pi,long destActInstID,String backStrategy, long hintEventID,WFProcessInstInternal procInst) {
        WFEvent event = new WFEvent(WFEventType.BACKWORD_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
        event.setProcessDefID(processDefID);
        event.setProcInstID(processInstID);
        event.setActDefID(activityDefID);
        event.setActInstID(activityInstID);
        event.setProcessInstance(procInst);
        
        WFEventBackActivityStrategy sty;
        if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_PATHBASED)){
        	sty=WFEventBackActivityStrategy.STRATEGY_PATH;
        }else if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_TIMEBASED)){
        	sty=WFEventBackActivityStrategy.STRATEGY_TIME;
        }else if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_SIMPLE)){
        	sty=WFEventBackActivityStrategy.STRATEGY_SIMPLE;
        }else if (backStrategy.equals(RollbackConst.ROLL_BACK_STRY_RECENT_MANUAL)){
        	sty=WFEventBackActivityStrategy.STRATEGY_RECENT_MANUAL;
        }else{
        	sty = WFEventBackActivityStrategy.STRATEGY_ONESTEP;
        }
        
        WFEventBackActivityParameter para = new WFEventBackActivityParameter(sty,null,destActInstID);
        event.setContext(para);

        WFEventFactoryHelp.fillEventFields(event);
        return event;
    }


	/**
	 * @param processDefID
	 * @param processInstID
	 * @param id
	 * @param privateInfo
	 * @return
	 */
	public static WFEvent createRestartActEvent(long processDefID, long processInstID, String activityDefID,long activityInstID, WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst,boolean isRestartWI) {
		WFEvent event = new WFEvent(WFEventType.RESTART_ACTIVITY,pi,Thread.currentThread().getName(),hintEventID,procInst);
		event.setProcessDefID(processDefID);
		event.setProcInstID(processInstID);
		event.setActDefID(activityDefID);
		event.setActInstID(activityInstID);
		event.setProcessInstance(procInst);
		event.setContext(isRestartWI);
		WFEventFactoryHelp.fillEventFields(event);
		return event;
	}
	/**
	 * @param processDefID
	 * @param processInstID
	 * @param id
	 * @param privateInfo
	 * @return
	 */
	public static WFEvent createRestartActEvent(long processDefID, long processInstID, String activityDefID,long activityInstID, WFPrivateInfo pi,long hintEventID,WFProcessInstInternal procInst) {
       
        return createRestartActEvent(processDefID, processInstID, activityDefID, activityInstID, pi, hintEventID, procInst,true);
	}
	/**
	 * @param processDefID
	 * @param processInstID
	 * @param id
	 * @param privateInfo
	 * @return
	 */
	public static WFEvent createTaskHasFinishedEvent(WFWorkItemInternal wi, WFPrivateInfo pi,long hintEventID) {
		long procInstID = wi.getProcessInstID();
		long actInstID	= wi.getActivityInstID();      
		String actDef = wi.getActivityDefID();
		long procDefID = wi.getProcessDefID();
		WFEvent event = new WFEvent(WFEventType.SUB_TASK_FINISHED,pi,Thread.currentThread().getName(),hintEventID,null);
		event.setProcessDefID(procDefID);
		event.setProcInstID(procInstID);
		event.setActDefID(actDef);
		event.setActInstID(actInstID);
		event.setWorkItemID(wi.getWorkItemID());
		WFEventFactoryHelp.fillEventFields(event);
		return event;
	}

	
	/**
	 * @param procInstID
	 * @param actInstID
	 * @param privateInfo
	 * @return 
	 */
	public static WFEvent createApplicatinReturnEvent(long procInstID, long actInstID, WFPrivateInfo privateInfo) {
		WFEvent event = new WFEvent(WFEventType.APPLICATION_RETURN);
		event.setProcInstID(procInstID);
		event.setActInstID(actInstID);
		event.setPrivateInfo(privateInfo);
		WFEventFactoryHelp.fillEventFields(event);
		return event;
		
	}
	
	public static WFEvent createTaskCreateEvent(long actInstID,TaskOption map){
		WFEvent event = new WFEvent(WFEventType.TASK_CREATE);
		event.setActInstID(actInstID);
		event.setContext(map);
		return event;
	}
	
	public static WFEvent createTaskSuspendEvent(long workItemID){
		WFEvent event = new WFEvent(WFEventType.TASK_SUSPEND);
		event.setWorkItemID(workItemID);
		return event;
	}
	
	public static WFEvent createTaskResumeEvent(long workItemID){
		WFEvent event = new WFEvent(WFEventType.TASK_RESUME);
		event.setWorkItemID(workItemID);
		return event;
	}
	
	public static WFEvent createTaskTerminateEvent(long workItemID){
		WFEvent event = new WFEvent(WFEventType.TASK_TERMINATE);
		event.setWorkItemID(workItemID);
		return event;
	}
	
	public static WFEvent createTaskRestartEvent(long workItemID,TaskOption map){
		WFEvent event = new WFEvent(WFEventType.TASK_RESTART);
		event.setWorkItemID(workItemID);
		event.setContext(map);
		return event;
	}

	public static WFEvent createTaskFinishEvent(long workItemID, WFPrivateInfo privateInfo,boolean splitTransaction){
		WFEvent event = new WFEvent(WFEventType.TASK_FINISH);
		event.setWorkItemID(workItemID);
		event.setPrivateInfo(privateInfo);
		event.setUseTxSegment(splitTransaction);
		return event;
	}
	
	
	public static WFEvent createTaskAbortEvent(long workItemID){
		WFEvent event = new WFEvent(WFEventType.TASK_ABORT);
		event.setWorkItemID(workItemID);
		return event;
	}
}