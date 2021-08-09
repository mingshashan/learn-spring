package com.example.demo.lc.l105;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class Solution {

    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void test02() {
        int[] preOrder = new int[]{-1};
        int[] inOrder = new int[]{-1};

        Solution solution = new Solution();
        TreeNode result = solution.buildTree(preOrder, inOrder);
        System.out.println(result);
    }

    private static void test01() {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        Solution solution = new Solution();
        TreeNode result = solution.buildTree(preOrder, inOrder);
        System.out.println(result);
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (null == preOrder || null == inOrder || 0 == preOrder.length || 0 == inOrder.length) {
            return null;
        }

        if (preOrder.length != inOrder.length) {
            throw new IllegalArgumentException("illegal argument");
        }

        if (1 == preOrder.length) {
            return new TreeNode(preOrder[0]);
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        int preStart = 0, inStart = 0;
        int preEnd = preOrder.length - 1, inEnd = preOrder.length - 1;

        TreeNode head = buildTree(preOrder, preStart, preEnd, inOrder, inStart, inEnd, inMap);
        return head;
    }

    private TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRootIndex = inMap.get(root.val);
        int inLeft = inRootIndex - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + inLeft, inOrder, inStart, inRootIndex - 1, inMap);
        root.right = buildTree(preOrder, preStart + inLeft + 1, preEnd, inOrder, inRootIndex + 1, inEnd, inMap);

        return root;
    }


}
