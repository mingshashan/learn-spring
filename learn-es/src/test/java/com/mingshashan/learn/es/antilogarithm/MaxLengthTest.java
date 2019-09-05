/*******************************************************************************
 *
 * Copyright (c) 2001-2018 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on  
 *******************************************************************************/

package com.mingshashan.learn.es.antilogarithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * MaxLengthTest
 *
 * @Description TODO
 */
public class MaxLengthTest {

    @Test
    public void lengthOfLongestSubstringTest() {

        MaxLength maxLength = new MaxLength();
        Assert.assertTrue(2 == maxLength.lengthOfLongestSubstring("abba"));
        Assert.assertTrue(3 == maxLength.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertTrue(1 == maxLength.lengthOfLongestSubstring("bbbbb"));
        Assert.assertTrue(3 == maxLength.lengthOfLongestSubstring("pwwkew"));
        Assert.assertTrue(4 == maxLength.lengthOfLongestSubstring("aaaaabbbbbcccccefgg"));
        Assert.assertTrue(1 == maxLength.lengthOfLongestSubstring("aa"));
        Assert.assertTrue(1 == maxLength.lengthOfLongestSubstring("aaa"));
        Assert.assertTrue(1 == maxLength.lengthOfLongestSubstring("a"));
        Assert.assertTrue(1 == maxLength.lengthOfLongestSubstring(" "));
        Assert.assertTrue(1 == maxLength.lengthOfLongestSubstring("  "));
        Assert.assertTrue(2 == maxLength.lengthOfLongestSubstring("      e       "));
        Assert.assertTrue(2 == maxLength.lengthOfLongestSubstring("au"));
        Assert.assertTrue(3 == maxLength.lengthOfLongestSubstring("dvdf"));
        Assert.assertTrue(8 == maxLength.lengthOfLongestSubstring("bcabcdefagy"));


    }

}
