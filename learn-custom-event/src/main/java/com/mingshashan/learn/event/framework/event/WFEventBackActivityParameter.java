/*
 * 创建日期 2005-5-23
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.mingshashan.learn.event.framework.event;

/**
 * @author LiuHang
 *
 * TODO 要更改此生成的类型注释的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class WFEventBackActivityParameter {
	
	WFEventBackActivityStrategy backStrategy;
	String destActDefID;
	long destActInstID;
	/**
	 * @return 返回 backStrategy。
	 */
	public WFEventBackActivityStrategy getBackStrategy() {
		return backStrategy;
	}
	/**
	 * @return 返回 destActDefID。
	 */
	public String getDestActDefID() {
		return destActDefID;
	}
	
	public long getDestActInstID() {
		return destActInstID;
	}
	
	public WFEventBackActivityParameter(WFEventBackActivityStrategy v_backStrategy,String v_destActDefID,long v_destActInstID)
	{
		this.backStrategy = v_backStrategy;
		this.destActDefID = v_destActDefID;
		this.destActInstID = v_destActInstID;
	}
	 
}
