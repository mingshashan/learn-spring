package com.example.demo.lc.l21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = new Solution().mergeTwoLists(l1, l2);
        System.out.println(result);
    }

    private static void test2() {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);

        ListNode result = new Solution().mergeTwoLists(l1, l2);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }

        ListNode temp = new ListNode(-1);
        ListNode p = temp;
        ListNode p1 = l1, p2 = l2;
        while (null != p1 && null != p2) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return temp.next;
    }
}