package com.wxh.algorithm.week03;

import com.wxh.algorithm.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 2020-06-03 09:33:53
 * */
public class ReversePrint_6 {
    /**
     * Stack
     * Time Complexity: O(n) + O(n)
     * Space Complexity: O(n)
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addFirst(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int v : list) {
            res[i++] = v;
        }
        return res;
    }

    /**
     * Recursion
     * */
    public int[] reversePrint2(ListNode head) {
        recursion(head);
        return Arrays.copyOf(tmp,i + 1);
    }
    int[] tmp = new int[10000];
    int i = 0;
    void recursion(ListNode head) {
        if (head == null) return;
        recursion(head.next);
        tmp[i++] = head.val;
    }
}
