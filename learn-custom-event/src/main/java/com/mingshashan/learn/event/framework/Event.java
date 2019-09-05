
package com.mingshashan.learn.event.framework;

import com.mingshashan.learn.event.framework.event.WFEventResult;
import com.primeton.workflow.api.IWFInstancePool;
import com.primeton.workflow.commons.utility.ToStringHelp;
import com.primeton.workflow.event.framework.event.WFEventType;
import com.primeton.workflow.model.engine.WFPrivateInfo;
import com.primeton.workflow.service.das.model.entities.WFActivityInstInternal;
import com.primeton.workflow.service.das.model.entities.WFProcessInstInternal;
import com.primeton.workflow.service.das.model.entities.WFWorkItemInternal;
import com.primeton.workflow.service.framework.WFServiceFactory;


/**
 * @author LiuHang
 * <p>
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Event extends EventObject {
    public static final int DISPATCH_HINT_SELFTHREAD = 1;
    public static final int DISPATCH_HINT_OTHERTHREAD = 2;

    private int type;                    //事件类型
    private long processDefID;            //流程ID
    private long procInstID;                //流程实例ID
    private String actDefID;            //活动ID
    private long actInstID;                //活动实例ID
    private long workItemID;                //工作项ID
    private Object context;                //附加参数对象
    private WFPrivateInfo privateInfo;    //调用者信息
    private String senderThreadName;    //发送者线程ID
    private WFEventResult eventResult = new WFEventResult();  //事件执行结果
    private WFEventContextList eventContextList = null;
    private EventContext ownerEventCtx;
    private WFProcessInstInternal processInstance;
    boolean isUseTxSegment;
    private boolean isRestartAppointed;

    public Event() {
    }

    public Event(int eventType) {
        this.type = eventType;
    }

    public Event(int eventType, WFPrivateInfo pi, String sendThreadName, long hintEventID, WFProcessInstInternal procInst) {
//		this.setHintEventID(hintEventID);
        this.type = eventType;
        this.privateInfo = pi;
        this.senderThreadName = sendThreadName;
    }

    @Override
    public String toString() {
        String ret = "";
        ret = ret + ToStringHelp.getFieldString("type", getTypeName(type));
        ret = ret + ToStringHelp.getFieldString("processDefID", processDefID);
        ret = ret + ToStringHelp.getFieldString("procInstID", procInstID);
        ret = ret + ToStringHelp.getFieldString("actDefID", actDefID);
        ret = ret + ToStringHelp.getFieldString("actInstID", actInstID);
        ret = ret + ToStringHelp.getFieldString("workItemID", workItemID);
        if (this.eventContextList != null) {
            ret = ret + "\n SubContext:" + this.eventContextList.toString();
        }
        //ret = ret +ToStringHelp.getFieldString("context",context.toString());
        return ret;
    }

    private String getTypeName(int t) {
        return WFEventType.getTypeName(t);
    }

    public WFProcessInstInternal getProcessInstance() {
        if (this.processInstance == null) {
//            this.processInstance = WFServiceFactory.getService(IWFInstancePool.class).findProcessInstanceByID(this.procInstID);
            this.processInstance = WFServiceFactory.getService(IWFInstancePool.class).findProcessInstanceByID(this.procInstID);
        }
        return this.processInstance;
    }

    public WFActivityInstInternal getActivityInstance() {
        return (WFActivityInstInternal) getProcessInstance().getProcessInstContext().findActInstByID(this.actInstID);
    }

    public WFWorkItemInternal getWorkItem() {
        WFActivityInstInternal actInstInPool = (WFActivityInstInternal) getProcessInstance().getProcessInstContext().findActInstByID(this.actInstID);
        return (WFWorkItemInternal) actInstInPool.getActivityInstContext().findWorkItemByID(
                this.workItemID);
    }


    public void setProcessInstance(WFProcessInstInternal procInst) {
        this.processInstance = procInst;
    }

    /**
     * @return Returns the actDefID.
     */
    public String getActDefID() {
        return actDefID;
    }

    /**
     * @param actDefID The actDefID to set.
     */
    public void setActDefID(String actDefID) {
        this.actDefID = actDefID;
    }

    /**
     * @return Returns the actInstID.
     */
    public long getActInstID() {
        return actInstID;
    }

    /**
     * @param actInstID The actInstID to set.
     */
    public void setActInstID(long actInstID) {
        this.actInstID = actInstID;
    }

    /**
     * @return Returns the context.
     */
    public Object getContext() {
        return context;
    }

    /**
     * @param context The context to set.
     */
    public void setContext(Object context) {
        this.context = context;
    }


    /**
     * @return Returns the procInstID.
     */
    public long getProcInstID() {
        return procInstID;
    }

    /**
     * @param procInstID The procInstID to set.
     */
    public void setProcInstID(long procInstID) {
        this.procInstID = procInstID;
    }

    /**
     * @return Returns the type.
     */
    public int getType() {
        return type;
    }

    /**
     * @param type The type to set.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return Returns the workItemID.
     */
    public long getWorkItemID() {
        return workItemID;
    }

    /**
     * @param workItemID The workItemID to set.
     */
    public void setWorkItemID(long workItemID) {
        this.workItemID = workItemID;
    }

    /**
     * @return Returns the processDefID.
     */
    public long getProcessDefID() {
        return processDefID;
    }

    /**
     * @param processDefID The processDefID to set.
     */
    public void setProcessDefID(long processDefID) {
        this.processDefID = processDefID;
    }


    public WFPrivateInfo getPrivateInfo() {
        return privateInfo;
    }

    public void setPrivateInfo(WFPrivateInfo privateInfo) {
        this.privateInfo = privateInfo;
    }


    /**
     * @return Returns the senderThreadName.
     */
    public String getSenderThreadName() {
        return senderThreadName;
    }

    /**
     * @return Returns the eventResult.
     */
    public WFEventResult getEventResult() {
        return eventResult;
    }

    public WFEventContextList findEventContextList() {
        return eventContextList;
    }

    public boolean hasChildContext() {
        if (eventContextList == null) return false;
        else return eventContextList.size() != 0;
    }

    public EventContext addChildContext() {
        if (eventContextList == null) eventContextList = new WFEventContextList();
        EventContext ret = eventContextList.addEventContext();
        ret.setParent(this);
        return ret;
    }

    public EventContext getOwnerEventCtx() {
        return ownerEventCtx;
    }

    public void setOwnerEventCtx(EventContext aCtx) {
        ownerEventCtx = aCtx;
    }

    /**
     * @return Returns the isUseTxSegment.
     */
    public boolean isUseTxSegment() {
        return isUseTxSegment;
    }

    /**
     * @param isUseTxSegment The isUseTxSegment to set.
     */
    public void setUseTxSegment(boolean isUseTxSegment) {
        this.isUseTxSegment = isUseTxSegment;
    }

    public boolean isRestartAppointed() {
        return isRestartAppointed;
    }

    public void setRestartAppointed(boolean isRestartAppointed) {
        this.isRestartAppointed = isRestartAppointed;
    }
}


