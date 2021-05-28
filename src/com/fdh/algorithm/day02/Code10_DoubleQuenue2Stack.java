package com.fdh.algorithm.day02;


import java.util.*;

/**
 * 双队列实现栈:两个杯子倒水原理。（此杯子水只能从底部流出上面流入）
 * 核心原理还是杯子倒水（沙子），
 * 装有沙子的杯子，先把沙子导入另外一个杯子，流1ml（1个数据），拿出来（此时追加数据在另外一个杯子操作）；
 * 然后倒第二个杯子沙子到第一个。留1ml
 * 注：使用ArrayDeque更简单，它有操作头尾的方法
 */
public class Code10_DoubleQuenue2Stack<E> {

    private Queue<E> queue1;

    private Queue<E> queue2;


    public Code10_DoubleQuenue2Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }


    private void push(E e) {
        queue1.add(e);
    }

    private E pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        E poll = queue1.poll();
        Queue temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return poll;
    }


    private E peek() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        E poll = queue1.poll();
        queue2.add(poll);
        Queue temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return poll;
    }

    private boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {

        Code10_DoubleQuenue2Stack code10_doubleQuenue2Stack = new Code10_DoubleQuenue2Stack();
        for (int i = 0; i < 10; i++) {
            code10_doubleQuenue2Stack.push(i);
        }

        for (int i = 0; i < 10; i++) {

//            arrayDeque.poll();
            System.out.println(code10_doubleQuenue2Stack.pop());

        }
    }
}
