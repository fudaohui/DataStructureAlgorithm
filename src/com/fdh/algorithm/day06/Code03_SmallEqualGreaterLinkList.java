package com.fdh.algorithm.day06;


import com.fdh.algorithm.day02.LinkListUtil;
import com.fdh.algorithm.day02.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 */
public class Code03_SmallEqualGreaterLinkList {


    /**
     * 将单向链表按某值划分成左边小、中间相等、右边大的形式
     * [将链表数据放入数组中，在数组中partion]
     *
     * @param head
     * @param target
     * @return
     * @see com.fdh.algorithm.day03.Code04_PartionionSort
     */
    public static Node linkListPartion1(Node head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        List<Node> nodeList = new ArrayList<Node>();
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }
        Node[] nodes = nodeList.toArray(new Node[nodeList.size()]);
        nodeArrPartion(nodes, target);
        head = cur = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            cur.next = nodes[i];
            cur = nodes[i];
        }
        cur.next = null;
        return head;

    }

    /**
     * 荷兰国旗问题
     *
     * @param nodes
     * @param target
     */
    private static void nodeArrPartion(Node[] nodes, int target) {

        int lessIndex = -1;
        int greaterIndex = nodes.length;
        int index = 0;
        while (index < greaterIndex) {
            if (nodes[index].getValue() < target) {
                swap(nodes, index++, ++lessIndex);
            } else if (nodes[index].getValue() > target) {
                swap(nodes, index, --greaterIndex);
            } else {
                index++;
            }
        }
    }


    /**
     * 三段链表衔接
     *
     * @param head
     * @param target
     */
    private static Node linkListPartion2(Node head, int target) {

        Node sH = null;//小于区的头节点
        Node sT = null;//小于区的尾节点
        Node eH = null;//等于
        Node eT = null;//等于
        Node gH = null;
        Node gT = null;
        Node next = null;
        while (head != null) {
            int value = head.getValue();
            next = head.next;
            head.next = null;
            if (value < target) {
                if (sH == null) {
                    sH = head;
                } else {
                    sT.next = head;
                }
                sT = head;
            } else if (value > target) {
                if (gH == null) {
                    gH = head;
                } else {
                    gT.next = head;
                }
                gT = head;
            } else {
                if (eH == null) {
                    eH = head;
                } else {
                    eT.next = head;
                }
                eT = head;
            }
            head = next;
        }
        //小于区连接等于区
        if (sH != null) {
            sT.next = eH;
            sT = (eT == null) ? sT : eT;
        }
        //等于连接大于区间
        if (eH != null) {
            eT.next = gH;
        }
        sH = sH == null ? (eH == null ? gH : eH) : sH;
        return sH;
    }

    public static void swap(Node[] nodes, int i, int j) {
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        LinkListUtil.printLinkList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = linkListPartion2(head1, 5);
        LinkListUtil.printLinkList(head1);

    }
}
