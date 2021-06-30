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


    /**
     * l两个无环链表相交问题，若相交返回相交节点;不相交返回null
     * 解题思路1：使用额外空间，集合，简单
     * 解题思路2：先找出两个链表长度的差值n，在找出长的那个链表让它走n步，然后两个链表一起走下去，直到数据不相等为止，
     * 即为第一个相交的点
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {//不相交
            return null;
        }
        //n >0,head1长度大于head2,反之，找到长的链表，从头走n步
        cur1 = n > 0 ? head1 : head2;//cur1代表长链表
        cur2 = cur1 == head1 ? head2 : head1;//cur2代表短链表

        n = Math.abs(n);
        while (n > 0) {
            n--;
            cur1 = cur1.next;
        }
        //此时长短链表到交点距离相同
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;

    }

    /**
     * 两个有环链表相交问题求交点
     *
     * @param head1
     * @param loop1 链表1的入环节点
     * @param head2
     * @param loop2 链表2的入环节点
     * @return
     */
    public static Node boseLoop(Node head1, Node loop1, Node head2, Node loop2) {

        if (loop1 == null || loop2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        //俩带环链表入环节点相同,求交点问题可以转化为将入环节点视为终点，两个无环链表相交求交点问题
        if (loop1 == loop2) {

            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop1) {
                n--;
                cur2 = cur2.next;
            }
            //找长短链表，假定cur1代表长链表，cur2代表短链表
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            //长链表走n步
            n = Math.abs(n);
            while (n > 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;

        } else {
            //入环节点不同，要么相交，要么不相交。判断方法是，loop1向下走看能否遇到loop2
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;//不相交

        }
    }


    /**
     * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
     * 请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
     * 可能的情况：
     * 1、俩链表都无环的情况，探讨相交与否的问题
     * 2、俩链表都有环的情况下，探讨相交与否的问题
     * 2.2 俩都有环，不相交
     * 2.2 俩都有环，入环节点是同一个点
     * 2.3 俩都有环，入环节点不是同一点
     * 3、一个有环一个无环，不存在相交的问题
     *
     * @return
     */
    public static Node twoLinkListIntersect() {

        return null;
    }

    public void testHasLoop() {
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

    public static void testTwoIntersectNoLoop() {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        Node cur1 = head1.next.next = new Node(3);

        Node head11 = new Node(22);
        Node cur2 = head11.next = new Node(33);

//        for (int i = 0; i < 3; i++) {
//            cur2.next = cur1.next = new Node(i);
//            cur1 = cur1.next;
//            cur2 = cur2.next;
//        }
        Node node = noLoop(head1, head11);
        System.out.println(node.getValue());
    }

    public static void testboshLoop() {

        //1、俩有环不相交
//        Node head1 = new Node(1);
//        head1.next = new Node(2);
//        Node node = new Node(3);
//        head1.next.next = node;
//        head1.next.next.next = new Node(4);
//        head1.next.next.next.next = new Node(5);
//        head1.next.next.next.next.next = new Node(5);
//        head1.next.next.next.next.next.next = node;
//
//        Node head11 = new Node(1);
//        head11.next = new Node(2);
//        head11.next.next = new Node(3);
//        Node node11 = new Node(4);
//        head11.next.next.next = node11;
//        head11.next.next.next.next = new Node(5);
//        head11.next.next.next.next.next = new Node(5);
//        head11.next.next.next.next.next.next = node11;
//        //2、俩有环相交
//
//        Node node1 = boseLoop(head1, node, head11, node11);
//        System.out.println(node1.getValue());


        //1、俩有环相交,入环节点相同

//        Node head1 = new Node(1);
//        Node interestNode = new Node(2);
//        head1.next = interestNode;
//        Node loopNode = new Node(3);
//        interestNode.next = loopNode;
//        loopNode.next = new Node(4);
//        loopNode.next.next = new Node(5);
//        loopNode.next.next.next = new Node(5);
//        loopNode.next.next.next.next = loopNode;
//
//        Node head11 = new Node(11);
//        head11.next = new Node(22);
//        head11.next.next = new Node(33);
//        head11.next.next.next = interestNode;
//
//        Node node1 = boseLoop(head1, loopNode, head11, loopNode);
//        System.out.println(node1.getValue());
        //3、俩有环相交,入环节点不同

        Node head1 = new Node(1);
        head1.next = new Node(2);
        Node loopNode1 = new Node(3);
        head1.next.next = loopNode1;//L1入环节点1
        loopNode1.next = new Node(4);
        Node loopNode2 = new Node(5);//L2入环节点2
        loopNode1.next.next = loopNode2;
        loopNode2.next = new Node(5);
        loopNode2.next.next = new Node(6);
        loopNode2.next.next.next = loopNode1;

        Node head11 = new Node(11);
        head11.next = new Node(22);
        head11.next.next = new Node(33);
        head11.next.next.next = loopNode2;

        Node node1 = boseLoop(head1, loopNode1, head11, loopNode2);
        System.out.println(node1.getValue());

    }

    public static void main(String[] args) {

//        testHasLoop();
//        testTwoIntersectNoLoop();
        testboshLoop();
    }
}
