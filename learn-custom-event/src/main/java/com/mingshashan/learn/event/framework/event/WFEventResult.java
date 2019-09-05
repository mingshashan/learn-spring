/*
 * Created on 2004-10-31
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.mingshashan.learn.event.framework.event;

import java.util.HashMap;

/**
 * @author LiuHang
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class WFEventResult {
	public static final String RESULT_WORKITEMID = "_workItemID";
	boolean isSuccess;
	Throwable throwable;
	HashMap<String,Object> resultMap = new HashMap<String, Object>();
	/**
	 * @return Returns the isSuccess.
	 */
	public boolean isSuccess() {
		return isSuccess;
	}
	/**
	 * @param isSuccess The isSuccess to set.
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	/**
	 * @return Returns the throwable.
	 */
	public Throwable getThrowable() {
		return throwable;
	}
	/**
	 * @param throwable The throwable to set.
	 */
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
	
	public Object getAttribute(String key){
		return this.resultMap.get(key);
	}
	
	public void setAttribute(String key,Object value){
		this.resultMap.put(key,value);
	}
}
