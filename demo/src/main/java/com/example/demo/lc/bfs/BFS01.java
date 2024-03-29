package com.example.demo.lc.bfs;

import java.util.LinkedList;
import java.util.Queue;


public class BFS01 {

    public static void main(String[] args) {

    }

    int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // root也是一层，故depth初始化为1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();

                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            depth++;
        }

        return depth;
    }
}
