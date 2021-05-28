package com.fdh.algorithm.day02;


import java.util.Stack;

/**
 * 双栈实现队列结构
 * 可以理解为将杯子里面的沙子倒到另外一个杯子
 */
public class Code09_DoubleStack2Quenue<E> {

    /**
     * 只做压入
     */
    private Stack<E> pushStack;

    /**
     * 只做弹出
     */
    private Stack<E> popStack;


    public Code09_DoubleStack2Quenue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void addQuenue(E e) {
        pushStack.push(e);
    }

    public E remove() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new IllegalStateException("队列为空");
        }
        if (popStack.isEmpty()) {//弹出栈没有东西
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public static void main(String[] args) {

        int count = 20;

        Code09_DoubleStack2Quenue<Integer> integerCode09_doubleStack2Quenue = new Code09_DoubleStack2Quenue<>();

        for (int i = 0; i < count; i++) {
            integerCode09_doubleStack2Quenue.addQuenue(i);
        }

        for (int i = 0; i < count; i++) {
            System.out.println(integerCode09_doubleStack2Quenue.remove());
        }
    }

}
