/*******************************************************************************
 *
 * Copyright (c) 2001-2018 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on  
 *******************************************************************************/

package com.mingshashan.learn.learnspringframework.test;

import java.util.Observable;
import java.util.Observer;

/**
 * XiaoMing
 *
 * @Description TODO
 */
public class XiaoMing implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("小明看到新闻:" + arg);
    }
}
