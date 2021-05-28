package com.fdh.algorithm.day02;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * <p>
 * 1）pop、push、getMin操作的时间复杂度都是 O(1)。
 * <p>
 * 2）设计的栈类型可以使用现成的栈结构。
 */
public class Code08_GetMinStack<T extends Comparable> {

    /**
     * 存放数据的stack
     */
    private Stack<T> dataStack;
    /**
     * 存放最小值的stack
     */
    private Stack<T> mindataStack;


    public Code08_GetMinStack() {
        this.dataStack = new Stack<>();
        this.mindataStack = new Stack<>();
    }

    /**
     * 为null或者小于栈顶元素，直接入mindataStack
     * 大于mindataStack 重新入一份栈顶元素
     *
     * @param t
     */
    public void push(T t) {
        dataStack.push(t);
        if (!mindataStack.isEmpty() && t.compareTo(mindataStack.peek()) >= 0) {
            t = mindataStack.peek();
        }
        mindataStack.push(t);
    }

    public T pop() {
        if (dataStack.isEmpty()) {
            throw new IllegalStateException("栈空");
        }
        T pop = dataStack.pop();
        mindataStack.pop();
        return pop;
    }

    public T getStackMiniData() {
        if (dataStack.isEmpty()) {
            throw new IllegalStateException("栈空");
        }
        return mindataStack.peek();
    }


    public static void main(String[] args) {
        Code08_GetMinStack<Integer> integerCode08_getMinStack = new Code08_GetMinStack<>();
        integerCode08_getMinStack.push(5);
        integerCode08_getMinStack.push(6);
        integerCode08_getMinStack.push(4);
        integerCode08_getMinStack.push(3);
        integerCode08_getMinStack.push(1);
        integerCode08_getMinStack.push(11);

        for (int i = 0; i < 10; i++) {
            System.out.println("pop" + integerCode08_getMinStack.pop());
            System.out.println("min" + integerCode08_getMinStack.getStackMiniData());

        }
    }
}
