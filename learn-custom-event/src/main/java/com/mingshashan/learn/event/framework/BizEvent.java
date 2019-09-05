
package com.mingshashan.learn.event.framework;

import java.util.Map;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */
public class BizEvent extends Event {
	
	private String bizTableName;
	
	private Map<String,Object> bizInfo;
	
	

	public BizEvent() {
		super();
	}

	public BizEvent(int type, long processInstID, String bizTableName, Map<String, Object> bizInfo) {
		super();
		setProcInstID(processInstID);
		setType(type);
		this.bizTableName = bizTableName;
		this.bizInfo = bizInfo;
	}

	public Map<String, Object> getBizInfo() {
		return bizInfo;
	}

	public void setBizInfo(Map<String, Object> bizInfo) {
		this.bizInfo = bizInfo;
	}

	public String getBizTableName() {
		return bizTableName;
	}

	public void setBizTableName(String bizTableName) {
		this.bizTableName = bizTableName;
	}

}
