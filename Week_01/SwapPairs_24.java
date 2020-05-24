package com.wxh.algorithm;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表
/**
 *
 * 2020-05-21 08:07:51
 */
public class SwapPairs_24 {
    /**
     * Definition for singly-linked list. */
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


     /** Simple solution */
    public static ListNode swapPairs(ListNode head) {
         ListNode pre = new ListNode(0);
         pre.next = head;
         ListNode current = pre;
         while (current.next != null && current.next.next != null) {
             ListNode first = current.next;
             ListNode second = current.next.next;
             first.next = second.next;
             second.next = first;
             current.next = second;
             current = first;
         }
         return pre.next;
    }

    /** recursion */
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }
}
