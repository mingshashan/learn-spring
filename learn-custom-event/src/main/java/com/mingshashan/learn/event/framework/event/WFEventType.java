/*
 * Created on 2004-7-25
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.mingshashan.learn.event.framework.event;

import java.util.HashMap;

/**
 * @author LiuHang
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
@SuppressWarnings("unchecked")
public class WFEventType {
	public static final int START_PROCESS			    =10001;
	public static final int SCHEDULE_NEXT_ACTIVITY	=10002;
	public static final int BACKWORD_ACTIVITY		    =10003;
	public static final int SUSPEND_PROCESS			=10004;
	public static final int RESUME_PROCESS			=10005;
	public static final int CHANGE_PROCESS_STATE	    =10006;
	public static final int TERMINATE_PROCESS		    =10007;
	public static final int ABORT_PROCESS			    =10008;
	public static final int FINISH_PROCESS			=10009;
	
	public static final int PRESTART_ACTIVITY        =20000;//add in v51
	public static final int START_ACTIVITY			=20001;
	public static final int RESTART_ACTIVITY		    =20002;
	public static final int CHANGE_ACTIVITY_STATE	    =20003;
	public static final int FINISH_ACTIVITY			=20004;
	public static final int TERMINATE_ACTIVITY		=20005;
	public static final int ABORT_ACTIVITY			=20006;
	public static final int SUSPEND_ACTIVITY			=20007;
	public static final int RESUME_ACTIVITY			=20008;
	public static final int SUB_TASK_FINISHED       	=20009;

	//public static final int EXCEPTION_TIMOUT		=40001;
	public static final int EXCEPTION_PROC_TIMEOUT 	=40002;
	public static final int EXCEPTION_PROC_REMIND 	=40003;
	public static final int EXCEPTION_WI_TIMEOUT 	=40004;
	public static final int EXCEPTION_WI_REMIND   	=40005;

	public static final int APPLICATION_RETURN		=50001;
	
	public static final int TRIGGER_EVENT		=60001;
	
	public static final int TASK_FINISH        = 70001;
	public static final int TASK_RESTART        = 70002;
	public static final int TASK_TERMINATE      = 70003;
	public static final int TASK_CREATE         = 70004;
	public static final int TASK_SUSPEND        = 70005;
	public static final int TASK_RESUME         = 70006;
	public static final int TASK_ABORT         = 70007;
	
	public static final int BIZ_EVENT_TYPE_INIT  = 80001;
	public static final int BIZ_EVENT_TYPE_UPDATE = 80002;
	
	public static final int BIZ_EVENT_TYPE_REMOVE = 80003;

    static HashMap typeMap = new HashMap();
    
    static{
        typeMap.put(new Integer(START_PROCESS)          ,"START_PROCESS");
        typeMap.put(new Integer(SCHEDULE_NEXT_ACTIVITY) ,"SCHEDULE_NEXT_ACTIVITY" );
        typeMap.put(new Integer(BACKWORD_ACTIVITY)      ,"BACKWORD_ACTIVITY" );
        typeMap.put(new Integer(SUSPEND_PROCESS         ),"SUSPEND_PROCESS" );
        typeMap.put(new Integer(RESUME_PROCESS          ),"RESUME_PROCESS" );
        typeMap.put(new Integer(CHANGE_PROCESS_STATE    ),"CHANGE_PROCESS_STATE" );
        typeMap.put(new Integer(TERMINATE_PROCESS       ),"TERMINATE_PROCESS" );
        typeMap.put(new Integer(ABORT_PROCESS           ),"ABORT_PROCESS" );
        typeMap.put(new Integer(FINISH_PROCESS          ),"FINISH_PROCESS" );
        
        typeMap.put(new Integer(PRESTART_ACTIVITY       ),"PRESTART_ACTIVITY" );
        typeMap.put(new Integer(START_ACTIVITY          ),"START_ACTIVITY" );
        typeMap.put(new Integer(RESTART_ACTIVITY        ),"RESTART_ACTIVITY" );
        typeMap.put(new Integer(CHANGE_ACTIVITY_STATE   ),"CHANGE_ACTIVITY_STATE" );
        typeMap.put(new Integer(FINISH_ACTIVITY         ),"FINISH_ACTIVITY" );
        typeMap.put(new Integer(TERMINATE_ACTIVITY      ),"TERMINATE_ACTIVITY" );
        typeMap.put(new Integer(ABORT_ACTIVITY          ),"ABORT_ACTIVITY" );
        typeMap.put(new Integer(SUSPEND_ACTIVITY        ),"SUSPEND_ACTIVITY" );
        typeMap.put(new Integer(RESUME_ACTIVITY         ),"RESUME_ACTIVITY" );
        typeMap.put(new Integer(SUB_TASK_FINISHED         ),"SUB_TASK_FINISHED" );

        //public static final int EXCEPTION_TIMOUT      =40001;
        typeMap.put(new Integer(EXCEPTION_PROC_TIMEOUT  ),"EXCEPTION_PROC_TIMEOUT");
        typeMap.put(new Integer(EXCEPTION_PROC_REMIND   ),"EXCEPTION_PROC_REMIND");
        typeMap.put(new Integer(EXCEPTION_WI_TIMEOUT   ),"EXCEPTION_ACT_TIMEOUT");
        typeMap.put(new Integer(EXCEPTION_WI_REMIND    ),"EXCEPTION_ACT_REMIND");

        typeMap.put(new Integer(APPLICATION_RETURN      ),"APPLICATION_RETURN");
        

        typeMap.put(new Integer(TASK_FINISH   ),"TASK_FINISH" );
        typeMap.put(new Integer(TASK_CREATE         ),"TASK_CREATE" );
        typeMap.put(new Integer(TASK_RESTART      ),"TASK_RESTART" );
        typeMap.put(new Integer(TASK_RESUME          ),"TASK_RESUME" );
        typeMap.put(new Integer(TASK_SUSPEND        ),"TASK_SUSPEND" );
        typeMap.put(new Integer(TASK_TERMINATE         ),"TASK_TERMINATE" );
        
        typeMap.put(new Integer(BIZ_EVENT_TYPE_INIT          ),"BIZINFO_INIT" );
        typeMap.put(new Integer(BIZ_EVENT_TYPE_UPDATE        ),"BIZINFO_UPDATE" );
        typeMap.put(new Integer(BIZ_EVENT_TYPE_REMOVE         ),"BIZINFO_REMOVE" );
        
    }
    public static String getTypeName(int t) {
        String value = (String) typeMap.get(new Integer(t));
        return (value==null)? String.valueOf(t):value;
    }
}
