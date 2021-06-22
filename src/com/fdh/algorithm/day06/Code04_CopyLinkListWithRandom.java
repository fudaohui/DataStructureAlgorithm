package com.fdh.algorithm.day06;


import java.util.HashMap;
import java.util.Map;

/**
 * 一种特殊的单链表节点类描述如下
 * class Node {
 * int value;
 * Node next;
 * Node rand;
 * Node(int val) { value = val; }
 * }
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点 head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * 【要求】
 * 时间复杂度O(N)，额外空间复杂度O(1)
 */
public class Code04_CopyLinkListWithRandom {

    static class NodeRandom {
        private Integer value;
        private NodeRandom next;
        private NodeRandom rand;

        public NodeRandom(Integer value) {
            this.value = value;
        }

    }
    /**
     * 使用额外空间实现
     * @param head
     * @return
     */
    public static NodeRandom copyLinkListWithRandom(NodeRandom head){
        if (head == null) {
            return null;
        }
        Map<NodeRandom,NodeRandom> nodeRandomHashMap = new HashMap();
        NodeRandom cur = head;
        while (cur != null){
            nodeRandomHashMap.put(cur,new NodeRandom(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur !=null){
            nodeRandomHashMap.get(cur).next = nodeRandomHashMap.get(cur.next);
            nodeRandomHashMap.get(cur).rand = nodeRandomHashMap.get(cur.rand);
            cur =cur.next;
        }
        return nodeRandomHashMap.get(head);
    }

    /**
     * 不适用额外空间拷贝
     * 原链表 1->2->3，先变成1->1'->2->2'->3->3',然后在将1',2',3'剥离，不影响老的链表
     * @param head
     * @return
     */
    public static NodeRandom copyLinkListWithRandom1(NodeRandom head){
        if (head == null) {
            return null;
        }
        NodeRandom cur = head;
        //1->1'->2->2'->3->3' set next
        while (cur != null){
            NodeRandom next = cur.next;
            cur.next = new NodeRandom(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //set rand
        cur = head;
        NodeRandom next = null;
        NodeRandom copyNode = null;
        while (cur != null){
            next = cur.next.next;//保存老的next
            copyNode = cur.next;
            copyNode.rand = cur.rand==null?null:cur.rand.next;//新节点’给rand指针
            cur = next;
        }
        //剥离粘连一块的链表
        NodeRandom newHead = head.next;
        cur = head;
        while (cur !=null){
            next = cur.next.next;//保存老的next
            copyNode = cur.next;
            cur.next = next;//老链表连上老的节点
            copyNode.next = next == null?null:next.next;
            cur = next;
        }
        return newHead;
    }
    public static void printRandLinkedList(NodeRandom head) {
        NodeRandom cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        NodeRandom head = null;
        NodeRandom res1 = null;
        NodeRandom res2 = null;
//        printRandLinkedList(head);
//        res1 = copyLinkListWithRandom(head);
//        printRandLinkedList(res1);
//        res2 = copyLinkListWithRandom1(head);
//        printRandLinkedList(res2);
//        printRandLinkedList(head);
//        System.out.println("=========================");

        head = new NodeRandom(1);
        head.next = new NodeRandom(2);
        head.next.next = new NodeRandom(3);
        head.next.next.next = new NodeRandom(4);
        head.next.next.next.next = new NodeRandom(5);
        head.next.next.next.next.next = new NodeRandom(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("--------原始-------");
        printRandLinkedList(head);
        System.out.println("--------方法1操作-------");
        res1 = copyLinkListWithRandom(head);
        printRandLinkedList(res1);
        System.out.println("--------方法2操作-------");
        res2 = copyLinkListWithRandom1(head);
        printRandLinkedList(res2);
        System.out.println("--------原始头-------");
        printRandLinkedList(head);
        System.out.println("=========================");

    }


}
