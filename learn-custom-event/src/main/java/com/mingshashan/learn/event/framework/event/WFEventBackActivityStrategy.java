/*
 * 创建日期 2005-5-23
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.mingshashan.learn.event.framework.event;

import java.io.Serializable;

/**
 * @author LiuHang
 *
 * TODO 要更改此生成的类型注释的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class WFEventBackActivityStrategy implements Serializable {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -5246658557445440677L;
	/**
	 * 回退到最近发生的人工活动．
	 * 如果存在多个聚合分支，则只回退最近的一条
	 */
	public static final WFEventBackActivityStrategy STRATEGY_RECENT_MANUAL=new WFEventBackActivityStrategy("RECENT_MANUAL");
	/**
	 * 回退到上一步
	 * 如果存在多个聚合分支，则只回退所有
	 */
	public static final WFEventBackActivityStrategy STRATEGY_ONESTEP=new WFEventBackActivityStrategy("ONESTEP");
	/**
	 * 根据时间回退
	 */
	public static final WFEventBackActivityStrategy STRATEGY_TIME=new WFEventBackActivityStrategy("TIME");;
	/**
	 * 根据路径回退
	 */
	public static final WFEventBackActivityStrategy STRATEGY_PATH=new  WFEventBackActivityStrategy("PATH");;
	/**
	 * 简单回退
	 */
	public static final WFEventBackActivityStrategy STRATEGY_SIMPLE=new WFEventBackActivityStrategy("SIMPLE");;
	
	private String strategy;
	private WFEventBackActivityStrategy(String s){
		this.strategy = s;
	}
	public String toString(){
		return strategy;
	}
	
}
