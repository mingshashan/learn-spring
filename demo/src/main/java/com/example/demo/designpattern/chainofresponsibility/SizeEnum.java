package com.example.demo.designpattern.chainofresponsibility;

/**
 * size枚举
 */
public enum SizeEnum {
    /**
     * 错误size(不可能有这个类别)
     */
    SIZE_UNKNOWN,
    /**
     * 小果，直径小于70
     */
    SIZE_SMALL,
    /**
     * 70果，直径大于70小于80
     */
    SIZE_70,
    /**
     * 80果，直径大于80小于90
     */
    SIZE_80,

    /**
     * 90果，直径大于90
     */
    SIZE_90;
}
