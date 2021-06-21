package com.fdh.algorithm.day06;


import com.fdh.algorithm.day02.LinkListUtil;
import com.fdh.algorithm.day02.Node;

import java.util.Stack;

/**
 * 判断回文链表，结构如下：
 * 1->2->3->2->1
 */
public class Code02_PalindromeLinkList {


    /**
     * 需要N的空间复杂度
     * 使用stack
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeLinkList1(Node head) {
        //少于3个直接判断
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.getValue() == head.next.getValue();
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.getValue() != stack.pop().getValue()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 使用快慢指针，在节约n/2空间
     * 注：找到中点或者上中点位置
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeLinkList2(Node head) {
        //少于3个直接判断
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.getValue() == head.next.getValue();
        }
        Stack<Node> stack = new Stack<>();
        Node tortoise = head;
//        for (int i = 0; i < 2; i++) {
//            stack.push(tortoise);
//            tortoise = tortoise.next;
//        }
        Node rabbit = head;
        stack.push(tortoise);
        while (rabbit.next != null && rabbit.next.next != null) {
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
            stack.push(tortoise);
        }
        tortoise = tortoise.next;
        while (tortoise != null) {
            if (tortoise.getValue() != stack.pop().getValue()) {
                return false;
            }
            tortoise = tortoise.next;
        }
        return true;
    }

    public static void main(String[] args) {

//        int[] a = {1};
//        int[] a = {1, 2, 2, 1,0};
        int[] a = {1, 2, 3,3,2, 1};
        Node head = new Node(a[0]);
        Node cur = head;
        for (int i = 1; i < a.length; i++) {
            Node node = new Node(a[i]);
            cur.next = node;
            cur = node;
        }
        LinkListUtil.printLinkList(head);
        System.out.println(isPalindromeLinkList1(head));
        System.out.println(isPalindromeLinkList2(head));
    }

}
