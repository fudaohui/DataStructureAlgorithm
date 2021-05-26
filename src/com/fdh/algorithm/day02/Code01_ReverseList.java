package com.fdh.algorithm.day02;

/**
 * 链表反转,单、双向链表
 */
public class Code01_ReverseList {


    /**
     * 旋转单链表
     *
     * @param head
     */
    public static Node reverseLinkList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        //返回的是pre，最后head肯定是null跳出while了
        return pre;
    }

    /**
     * 旋转双链表
     *
     * @param head
     */
    public static DoubleNode reverseDoubleLinkList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

//        Node head = LinkListUtil.generateRandomLinkList(18, 20);
//        LinkListUtil.printLinkList(head);
//        head = reverseLinkList(head);
//        LinkListUtil.printLinkList(head);

        DoubleNode doubleNode = LinkListUtil.generateRandomDoubelLinkList(18, 20);
        LinkListUtil.printLinkList(doubleNode);
        doubleNode = reverseDoubleLinkList(doubleNode);
        LinkListUtil.printLinkList(doubleNode);
    }
}
