package com.fdh.algorithm.day02;

/**
 * 链表反转
 */
public class Code01_ReverseList {


    /**
     * 旋转单链表
     *
     * @param head
     */
    public static Node reverseList(Node head) {
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

    public static void main(String[] args) {

        Node head = LinkListUtil.generateRandomLinkList(18, 20);
        LinkListUtil.printLinkList(head);
        head = reverseList(head);
        LinkListUtil.printLinkList(head);
    }
}
