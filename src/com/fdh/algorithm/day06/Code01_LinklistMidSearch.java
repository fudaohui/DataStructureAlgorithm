package com.fdh.algorithm.day06;

import com.fdh.algorithm.day02.LinkListUtil;
import com.fdh.algorithm.day02.Node;

/**
 * 链表中点查找问题,快慢指针
 */
public class Code01_LinklistMidSearch {

    /**
     * 查找链表的中点（奇数个）或上中点（偶数个）
     *
     * @param head
     * @return
     */
    public static Node searchaMidOrUpMidNote(Node head) {
        //要求链表至少三个节点
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {

        int count = 6;
        Node head = new Node(1);
        Node cur = head;
        for (int i = 2; i <= count; i++) {
            Node node = new Node(i);
            cur.next = node;
            cur = cur.next;
        }
        LinkListUtil.printLinkList(head);
        Node node = searchaMidOrUpMidNote(head);
        System.out.println(node.getValue());

    }

}
