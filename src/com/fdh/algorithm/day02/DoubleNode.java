package com.fdh.algorithm.day02;

/**
 * 双向链表
 */
public class DoubleNode<T> {

    public Integer value;
    public DoubleNode pre;
    public DoubleNode next;

    public DoubleNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
