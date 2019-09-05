/*******************************************************************************
 * $Header: /cvsroot/PTP50/workdir/bps/develop/src/server/com.primeton.bps.event.framework/src/main/java/com/primeton/workflow/event/framework/WFEventContextList.java,v 1.1 2013/10/11 17:30:01 haoyf Exp $
 * $Revision: 1.1 $
 * $Date: 2013/10/11 17:30:01 $
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2004 Primeton Technologies, Ltd.
 * All rights reserved. 
 * 
 * Created on 2006-8-23
 *******************************************************************************/

package com.mingshashan.learn.event.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO此处填写 class 信息
 *
 * @author liuhang (mailto:liuhang@primeton.com)
 */
/*
 * 修改历史
 * $Log: WFEventContextList.java,v $
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
 * Revision 1.1  2008/11/14 07:52:05  liuxj
 * Add:项目重命名，包命名
 *
 * Revision 1.1  2008/11/11 05:00:21  liuxj
 * Add:项目改名，包名重命名
 *
 * Revision 1.1  2008/09/22 03:29:42  liuxj
 * Add:项目拆分
 *
 * Revision 1.2  2007/08/30 02:18:56  haoyf
 * Update: 去掉无用的import
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
 * Revision 1.1  2007/05/16 12:24:12  liuhang
 * Add:share project
 *
 * Revision 1.3  2006/11/24 02:34:53  zhangyue
 * 同步
 *
 * Revision 1.1.2.2  2006/08/24 06:16:53  liuhang
 * refector codes
 *
 * Revision 1.1.2.1  2006/08/23 07:00:46  liuhang
 * UnitTest:修复了addEventCtx的错误
 * 
 */

public class WFEventContextList {
    private List innerList = new ArrayList();
    
    public String toString(){
        return innerList.toString();
    }
    /**
     * 增加
     * @return
     */
    @SuppressWarnings("unchecked")
	public EventContext addEventContext(){
       EventContext newCtx = new EventContext();
       innerList.add(newCtx);
       return newCtx;
    }
    /**
     * 获取上一个
     * @return
     */
    public EventContext getLastEventContext(){
        return (EventContext) innerList.get(innerList.size()-1);
    }
    /**
     * 获取大小
     * @return
     */
    public int size(){
        return innerList.size();
    }
    
    /**
     * 获取
     * @param pos
     * @return
     */
    public EventContext get(int pos){
        return (EventContext) innerList.get(pos);
    }

}



