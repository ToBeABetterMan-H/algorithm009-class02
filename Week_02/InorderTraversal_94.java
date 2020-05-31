package com.wxh.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 左 - 根 - 右
 *
 * 2020-05-31 17:04:57
 */
public class InorderTraversal_94 {
    /** recursion */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (root.left != null) res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        if (root.right != null) res.addAll(inorderTraversal(root.right));
        return res;
    }
}
