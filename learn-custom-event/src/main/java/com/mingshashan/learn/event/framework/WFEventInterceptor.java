/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/WFEventInterceptor.java,v 1.1 2013/10/11 17:30:01 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:01 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2004 Primeton Technologies, Ltd.
 * All rights reserved. 
 * 
 * Created on 2006-8-24
 *******************************************************************************/

package com.mingshashan.learn.event.framework;

import com.primeton.workflow.api.WFServiceException;


/**
 * TODO此处填写 class 信息
 *
 * @author liuhang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: WFEventInterceptor.java,v $
 * Revision 1.1  2013/10/11 17:30:01  haoyf
 * add: java 2 maven
 *
 * Revision 1.2  2013/09/04 13:34:30  wuyh
 * update:代码编码转换为UTF-8
 *
 * Revision 1.1  2013/08/23 11:38:24  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/22 13:00:00  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2013/08/21 10:51:27  wuyh
 * update:代码迁移 PTP5.0
 *
 * Revision 1.1  2009/06/24 07:56:45  haoyf
 * add:move cvs
 *
 * Revision 1.1  2009/04/02 07:14:34  haoyf
 * add:新项目迁移到主干
 *
 * Revision 1.2  2009/03/24 09:48:28  haoyf
 * update:重构
 *
 * Revision 1.1  2008/11/14 07:52:05  liuxj
 * Add:项目重命名，包命名
 *
 * Revision 1.1  2008/11/11 05:00:21  liuxj
 * Add:项目改名，包名重命名
 *
 * Revision 1.1  2008/09/22 03:29:42  liuxj
 * Add:项目拆分
 *
 * Revision 1.1  2007/08/28 09:57:43  haoyf
 * Update：重构修改包名错误
 *
 * Revision 1.1  2007/08/23 01:19:28  liuhang
 * Update:refector based on the third gread model
 *
 * Revision 1.1  2007/08/09 09:22:26  liuxj
 * Add:迁移项目到EOS Studio中
 *
 * Revision 1.2  2007/08/09 06:56:09  haoyf
 * Update：去掉无用的引用
 *
 * Revision 1.1  2007/05/16 12:24:12  liuhang
 * Add:share project
 *
 * Revision 1.3  2006/11/24 02:34:53  zhangyue
 * 同步
 *
 * Revision 1.1.2.2  2006/11/10 06:09:56  liuhang
 * 主要是增加异常的记录
 *
 * Revision 1.1.2.1  2006/08/24 06:16:53  liuhang
 * refector codes
 * 
 */

public interface WFEventInterceptor {
    /**
     * before execute 
     * @param aEvent
     * @return true:continue to dispose ; false:stop to dispose
     */
    public boolean beforeExecute(Event aEvent);
    
    /**
     * after execute
     * @param aEvent event disposed
     * @param th the exception may be null
     * @return
     * @throws WFServiceException 
     */
    public void afterExecute(Event aEvent) throws WFServiceException;

}



