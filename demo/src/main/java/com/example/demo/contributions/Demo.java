package com.example.demo.contributions;

import java.util.Arrays;

/**
 * Demo
 *
 * @author jasonxu
 */
public class Demo {
    public static void main(String[] args) {

        String test = "            <contributions>\n" +
                "                com.primeton.bfp.common.model,\n" +
                "                com.primeton.bfp.common.data,\n" +
                "                com.primeton.bfp.common.api,\n" +
                "                com.primeton.bfp.common.auth,\n" +
                "                com.primeton.bfp.common.velocity,\n" +
                "                com.primeton.bfp.common.componentization,\n" +
                "                com.primeton.bfp_.common.importexport,\n" +
                "            </contributions>";


//        "[\t_\n_\f_\r]", ""

//        test = test.replaceAll("[\t_\n_\f_\r_\\s]", "");
        test = test.replaceAll("[\t\n\f\r\\s]", "");

        String[] aaa = test.split(",");
        System.out.println(test);
        System.out.println(Arrays.toString(aaa));

    }
}
