package com.example.demo.lc.l99;

/**
 * Recover Binary Search Tree
 * you are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * <p>
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * <p>
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 * <p>
 * <p>
 * <p>
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 */
public class RecoverBST {


    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }


    /**
     * aa
     */
    private static void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new
                TreeNode(3);
        root.left.right = new TreeNode(2);
        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);

        System.out.println(root);
    }

    private static void test02() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);

        System.out.println(root);

    }


    private static void test03() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);

        System.out.println(root);

    }

    // BST中序遍历前一个节点一定比小
    // 找到两个节点，
    // 1,5,3,4,2 <-> 1,2,3,4,5
    // 5,2, 5 > 3 ---- 4 < 2


    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        if (null == root) {
            return;
        }

        searchTree(root);
        if (null != first && null != second && first.val != second.val) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }

    public void searchTree(TreeNode root) {
        if (null == root) {
            return;
        }

        searchTree(root.left);

        if (prev == null || (prev.val > root.val)) {
            if (first == null) {
                first = prev;
            }
        }

        if (first != null && (prev.val > root.val)) {
            second = root;
        }

        prev = root;
        searchTree(root.right);
    }

}
