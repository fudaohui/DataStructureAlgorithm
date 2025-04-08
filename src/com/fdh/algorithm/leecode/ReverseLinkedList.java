package com.fdh.algorithm.leecode;


import com.fdh.algorithm.day02.Node;

/**
 * 反转链表。
 * 单链表。1->2->3->4->null
 * null<-1《-2《->3《-4
 */
public class ReverseLinkedList {

    public static Node reverseLinkedList(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr.next != null) {
            Node next = curr.next;
            curr.next = prev;          // 反转指针方向
            prev = curr;               // prev前移
            curr = next;               // curr前移
        }
        return null;
    }
}
