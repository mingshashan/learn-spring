/*
 * Created on 2004-8-7
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.mingshashan.learn.event.framework.event;

import java.util.HashMap;

import com.primeton.workflow.api.WFServiceException;

/**
 * @author LiuHang
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
//BASE IS 20000
@SuppressWarnings({ "serial", "unchecked" })
public class WFEventException extends WFServiceException{
	
	public static HashMap registerError = new HashMap();
	
	public WFEventException(int code, Object[] params, Throwable cause) {
		super(code, params, cause);
		// TODO Auto-generated constructor stub
	}

	public WFEventException(int code, String message, Object[] params,
			Throwable cause) {
		super(code, message, params, cause);
		// TODO Auto-generated constructor stub
	}

	public WFEventException(int code, String message, Object[] params) {
		super(code, message, params);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param errorNO
	 */
	public WFEventException(int errorNO) {
		super(errorNO);
	}

	/**
	 * @param errorNO
	 * @param extraMSG
	 */
	public WFEventException(int errorNO, String extraMSG) {
		super(errorNO, extraMSG);
	}
	/**
	 * @param extraMSG
	 */
	public WFEventException(String extraMSG) {
		super(extraMSG);
	}
    
	/**
     * 
     * @param errorNO
     * @param extraMSG
	 */
    public WFEventException(Throwable cause,String msg) {
        
        super(cause, msg);
    }
    
    public WFEventException(int errorNO, Object[] params) {
		super(errorNO, params);
	}

	public WFEventException(int errorNO, String extraMSG, Throwable cause) {
		super(errorNO, extraMSG, cause);
	}

	public WFEventException(int errorNO, Throwable cause) {
		super(errorNO, cause);
	}

	public WFEventException(Throwable cause) {
		super(cause);
	}
    
}
