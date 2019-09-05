/*******************************************************************************
 *
 * Copyright (c) 2001-2018 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on  
 *******************************************************************************/

package com.mingshashan.learn.es.antilogarithm;

import java.util.LinkedList;

/**
 * MaxLength
 *
 * @Description TODO
 */
public class MaxLength {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        if (1 >= s.length()) {
            return s.length();
        }
        final int MAX_SIZE = 256;
        int[] charArray = new int[MAX_SIZE];
        int maxSize = 0;
        int beginIndex = 0;
        int endIndex;

        for (int i = 0; i < MAX_SIZE; i++) {
            charArray[i] = -1;
        }

        charArray[s.charAt(0)] = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charArray[c] != -1) {
                while (beginIndex <= charArray[c]) {
                    charArray[s.charAt(beginIndex)] = -1;
                    beginIndex++;
                }
            }
            charArray[c] = i;
            endIndex = i;
            maxSize = (endIndex - beginIndex + 1) > maxSize ? (endIndex - beginIndex + 1) : maxSize;
        }
        return maxSize;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        if (1 >= s.length()) {
            return s.length();
        }

        final int NO_OF_CHARS = 256;
        int n = s.length();
        int cur_len = 1;
        int max_len = 1;
        int prev_index;
        int i;
        int visited[] = new int[NO_OF_CHARS];

        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        visited[s.charAt(0)] = 0;

        for (i = 1; i < n; i++) {
            prev_index = visited[s.charAt(i)];

            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
            else {
                if (cur_len > max_len) {
                    max_len = cur_len;
                }

                cur_len = i - prev_index;
            }

            visited[s.charAt(i)] = i;
        }

        if (cur_len > max_len)
            max_len = cur_len;

        return max_len;
    }


    public int lengthOfLongestSubstring1(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        if (1 >= s.length()) {
            return s.length();
        }
        LinkedList<String> temp = new LinkedList<>();
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            String iStr = String.valueOf(s.charAt(i));

            if (temp.contains(iStr)) {
                while (temp.contains(iStr)) {
                    temp.removeFirst();
                }
                temp.addLast(iStr);
                continue;
            }
            temp.addLast(iStr);
            maxSize = maxSize > temp.size() ? maxSize : temp.size();
        }

        return maxSize;
    }

}
