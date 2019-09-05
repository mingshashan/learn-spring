/*******************************************************************************
 *
 * Copyright (c) 2001-2018 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on  
 *******************************************************************************/

package com.mingshashan.learn.es.antilogarithm;

/**
 * A02
 *
 * @Description TODO
 */
public class A02 {

    public static void main(String[] args) {

        int x = 0, y = 0, z = 0;
        for (x = 0; x <= 100 / 5; x++) {
            for (y = 1; y <= 100 / 3; y++) {
                for (z = 3; z <= 300; z += 3) {
                    if ((x + y + z == 100) && (5 * x + 3 * y + z / 3 == 100)) {
                        System.out.printf("x = %s, y = %s, z = %s \n", x, y, z);
                    }
                }
            }
        }

    }
}
