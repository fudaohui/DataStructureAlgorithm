package com.fdh.algorithm.day06;

import com.fdh.algorithm.day02.Node;

/**
 * 带环链表问题
 * 问题1：如何判断一个链表有环还是无环
 * 问题2：给定一个有环节点如何返回第一个入环的节点
 * 问题3：给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 */
public class Code05_LoopLinkList {


    /**
     * 判断一个链表是否有环，如有环，返回第一个入环节点；若无环，返回null
     * 方法一：最简单的办法使用额外空间的hashSet，先判断是否在集合不在入
     * 方法二：快慢指针（里面包含数学证明问题），这里使用方法二
     *
     * @param head
     * @return
     */
    public static Node getFirstLoopNode(Node head) {
        //空链表，单节点，双节点都不认为是环
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node tortoise = head.next;
        Node rabbit = head.next.next;
        while (tortoise != rabbit) {
            if (rabbit.next == null || rabbit.next.next == null) {
                return null;
            }
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
        }
        rabbit = head;//快指针回到头节点，然后各一步向前走，相遇的就是第一个入环节点，数据证明问题
        while (rabbit != tortoise) {
            rabbit = rabbit.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }


    public static void main(String[] args) {

//        1、判断是否有环
        Node head = new Node(1);
        Node cur = head;
        Node x = null;
        for (int i = 2; i < 10; i++) {
            Node node = new Node(i);
            if (i == 5) {
                x = node;
            }
            if (i == 9) {
                cur.next = x;
            } else {
                cur.next = node;
            }
            cur = cur.next;
        }
        cur.next = x;
        Node firstLoopNode = getFirstLoopNode(head);
        System.out.println(firstLoopNode.getValue());

    }
}
