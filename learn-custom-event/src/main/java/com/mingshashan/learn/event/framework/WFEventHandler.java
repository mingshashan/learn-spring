/*
 * Created on 2004-7-24
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.mingshashan.learn.event.framework;

import com.primeton.workflow.model.exception.WFException;
/**
 * @author LiuHang
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public interface WFEventHandler{
	public void invoke(Event event) throws WFException;
}
