package com.fdh.algorithm.day02;

/**
 * 链表的工具类
 */
public class LinkListUtil {

    /**
     * 产生随机数据的单项链表
     *
     * @param maxLen   随机链表的最大长度
     * @param maxValue 随机链表的最大值
     * @return
     */
    public static Node generateRandomLinkList(int maxLen, int maxValue) {
        int linkLen = (int) (Math.random() * (maxLen + 1));
        if (linkLen == 0) {
            return null;
        }
        int value = (int) (Math.random() * (maxValue + 1));
        Node head = new Node(value);
        linkLen--;
        Node cur = null;
        Node pre = head;
        while (linkLen > 0) {
            value = (int) (Math.random() * (maxValue + 1));
            cur = new Node(value);
            pre.next = cur;
            pre = cur;
            linkLen--;
        }
        return head;
    }


    public static void printLinkList(Node head) {
        if (head == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        while (head != null) {
            stringBuilder.append(head.getValue()).append(",");
            head = head.next;
        }
        System.out.println(stringBuilder.subSequence(0, stringBuilder.length() - 1).toString());
    }


    public static void main(String[] args) {
        Node head = generateRandomLinkList(20, 30);
        printLinkList(head);
    }
}
