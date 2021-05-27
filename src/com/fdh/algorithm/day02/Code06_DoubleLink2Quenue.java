package com.fdh.algorithm.day02;

/**
 *
 */
public class Code06_DoubleLink2Quenue {

    private DoubleNode head;

    private DoubleNode tail;

    //尾插法
    private void add(Integer target) {
        DoubleNode cur = new DoubleNode(target);
        if (head == null) {
            head = cur;
        } else {
            cur.pre = tail;
            tail.next = cur;
        }
        tail = cur;
    }

    /**
     * 头删除
     *
     * @return
     */
    private Integer remove() {
        if (isEmpty()) {
            throw new IllegalStateException("队列为null");
        }
        Integer headValue = head.getValue();
        DoubleNode cur = head.next;
        if (cur == null) {
            head = null;
        } else {
            head.next = null;
            cur.pre = null;
            head = cur;
        }
        return headValue;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Code06_DoubleLink2Quenue code06_doubleLink2Quenue = new Code06_DoubleLink2Quenue();
        for (int i = 0; i < 20; i++) {
            code06_doubleLink2Quenue.add(i);
        }

        for (int i = 0; i < 21; i++) {
            System.out.println(code06_doubleLink2Quenue.remove());

        }
    }
}
