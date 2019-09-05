package com.mingshashan.learn.event.framework.load;

import com.primeton.workflow.event.framework.WFEvent;
import com.primeton.workflow.service.das.model.notify.PersistentObject;

public class TriggerEvent extends WFEvent {
	
	private PersistentObject po = null;
	private Object defObject = null;
	private String triggerType = null;
	
	public TriggerEvent(){
		super(60001);
	}
    
    public TriggerEvent(PersistentObject po, Object def, String triggerType){
    	super(60001);
    	this.po = po;
    	this.defObject = def;
    	this.triggerType = triggerType;
	}

	public PersistentObject getPersistentObject() {
		return po;
	}

	public void setPersistentObject(PersistentObject po) {
		this.po = po;
	}

	public Object getDefinitionObject() {
		return defObject;
	}

	public void setDefinitionObject(Object defObject) {
		this.defObject = defObject;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}
	

}
