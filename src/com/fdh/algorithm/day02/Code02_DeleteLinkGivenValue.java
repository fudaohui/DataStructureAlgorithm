package com.fdh.algorithm.day02;

/**
 * 删除链表中给定的值
 */
public class Code02_DeleteLinkGivenValue {
    /**
     * 但链表删除指定的节点,
     * 考虑一下情况
     * 1、a,a,a,b,c,d....
     * 2、b,c,d,a,a，a....
     * <p>
     * 注:调用此方法后不要直接使用head,应该使用方法的返回值
     *
     * @param head 局部变量，地址值传递
     * @param node
     */
    public static Node deleteNode(Node head, Node node) {

        //指针停在第一个不为node的地方
        while (head != null) {
            if (head.getValue() != node.getValue()) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.getValue() == node.getValue()) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static DoubleNode deleteDoubleNode(DoubleNode head, DoubleNode node) {
        //指针停在第一个不为node的地方
        while (head != null) {
            if (head.getValue() != node.getValue()) {
                break;
            }
            head = head.next;
        }
        DoubleNode cur = head;
        DoubleNode pre = head;
        while (cur != null) {
            if (cur.getValue() == node.getValue()) {
                pre.next = cur.next;
                cur.next.pre = pre;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int maxLen = 15;

        Node head = new Node(5);
        Node cur = head;
        int[] a = {5, 6, 9, 15, 1, 5, 8, 5};
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            Node node = new Node(i1);
            cur.next = node;
            cur = node;
        }
        //单链表删除头节点
//        Node head = LinkListUtil.generateRandomLinkList(maxLen, 15);
//        Node head = LinkListUtil.generateRandomLinkList(maxLen, 15);
        System.out.println(head.getValue());
        LinkListUtil.printLinkList(head);
        head = deleteNode(head, head);
//        LinkListUtil.printLinkList(node);
        LinkListUtil.printLinkList(head);


        //双列表删除头节点
//        DoubleNode head = LinkListUtil.generateRandomDoubelLinkList(maxLen, 15);
//        LinkListUtil.printLinkList(head);
//        head = deleteDoubleNode(head, head);
//        LinkListUtil.printLinkList(head);
//        Node head = new Node(0);


//        Node head = LinkListUtil.generateRandomLinkList(maxLen, maxLen);
//        Node temp = head;
//        int len = 0;
//        while (temp != null) {//统计长度
//            temp = temp.next;
//            len++;
//        }
//        //随机拿出一个值
//        int index = (int) (Math.random() * (len));
//        Node target = head;
//        for (int i = 0; i < index; i++) {
//            target = target.next;
//        }
//        System.out.println("target:"+target.getValue());
//        LinkListUtil.printLinkList(head);
//        Node node = deleteNode(head, target);
//        LinkListUtil.printLinkList(head);
//        System.out.println("target:" + target.getValue());
//        LinkListUtil.printLinkList(head);
//        deleteDoubleNode(head, target);
//        deleteNode(head,target);
//        LinkListUtil.printLinkList(head);
    }
}
