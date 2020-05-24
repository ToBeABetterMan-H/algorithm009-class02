package com.wxh.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class MyDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.addLast("a");
        deque.addLast("b");
        deque.addFirst("c");
        deque.addFirst("d");
        System.out.println(deque);

        System.out.println("peekFirst: " + deque.peekFirst());
        System.out.println("peekLast: " + deque.peekLast());
        System.out.println("after peek: " + deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println("after pop: " + deque);
    }
}
