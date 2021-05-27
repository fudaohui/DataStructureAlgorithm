package com.fdh.algorithm.day02;

import java.util.EmptyStackException;

/**
 * 双向链表实现栈，头插法
 * 链表的特点：
 * 在内存中，不要求连续。
 * 每一个数据都保存了下一个数据的内存地址(指针)，通过这个指针指向下一个数据。
 * 增加和删除数据很容易。 （增加一个数，不需要动后面的数据，直接改变指针指向就行）
 * 查找效率低，只能重头开始依次遍历寻找。
 * 不指定大小，扩展方便。链表大小不用定义，数据随意增删。
 */
public class Code04_DoubleLink2Stack {

    private DoubleNode head;

    private DoubleNode tail;

    /**
     * 头插法
     *
     * @param value
     */
    private void addFromHead(Integer value) {
        DoubleNode cur = new DoubleNode(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.pre = cur;
            head = cur;
        }
    }

    /**
     * 头部弹出法，注意链表为null和head=tail的特殊情况
     *
     * @return
     */
    private Integer removerFromHead() {
        if (head == null) {
            throw new EmptyStackException();
        }
        //先记录值
        Integer value = head.getValue();
        //仅有一个元素
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            DoubleNode cur = head.next;
            cur.pre = null;
            head.next = null;
            head = cur;
        }
        return value;
    }


    public static void main(String[] args) {

        Code04_DoubleLink2Stack doubleLink2Stack = new Code04_DoubleLink2Stack();
        for (int i = 0; i < 20; i++) {
            doubleLink2Stack.addFromHead(i);
        }

        for (int i = 0; i < 21; i++) {
            System.out.println(doubleLink2Stack.removerFromHead());

        }
    }

}
