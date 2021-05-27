package com.fdh.algorithm.day02;

import java.util.EmptyStackException;

/**
 * 双向链表实现栈，头插法
 */
public class DoubleLink2Stack {

    private DoubleNode head;

    private DoubleNode tail;
    /**
     * 头插法
     *
     * @param value
     */
    private void addFromHead(Integer value) {
        DoubleNode cur = new DoubleNode<>(value);
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

        DoubleLink2Stack doubleLink2Stack = new DoubleLink2Stack();
        for (int i = 0; i < 20; i++) {
            doubleLink2Stack.addFromHead(i);
        }

        for (int i = 0; i < 21; i++) {
            System.out.println(doubleLink2Stack.removerFromHead());

        }
    }

}
