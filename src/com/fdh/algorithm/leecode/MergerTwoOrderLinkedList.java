package com.fdh.algorithm.leecode;

import com.fdh.algorithm.day02.Node;

public class MergerTwoOrderLinkedList {


    public static Node mergeTwoOrderLinkedList(Node head1, Node head2) {

        Node newHead = new Node(Integer.MIN_VALUE);
        //记录当前处理到哪些节点了
        Node curr = newHead;

        while (head1 != null && head2 != null) {

            if (head1.getValue() < head2.getValue()) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;//移动新节点当前处理的哪个节点
        }
        curr.next = head1 == null ? head2 : head1;
        return newHead.next;
    }
}
