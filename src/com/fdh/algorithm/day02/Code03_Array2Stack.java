package com.fdh.algorithm.day02;

import java.util.EmptyStackException;

/**
 * 数组实现栈的简单实现，没有考虑栈最大深度，和数组弹性自增
 */
public class Code03_Array2Stack<E> {
    /**
     * 当前元素的大小，也是数组的实际数据的index
     */
    private int elementCount;

    private Object[] elements;
    /**
     * 数据扩容的步长
     */
    private int increaseStep;

    /**
     * 初始容量大小
     */
    private int initCapacity;

    public Code03_Array2Stack(int increaseStep, int initCapacity) {
        this.increaseStep = increaseStep;
        this.initCapacity = initCapacity;
        elements = new Object[initCapacity];
    }

    public Code03_Array2Stack() {
    }

    public E push(E e) {
        addElement(e);
        return e;
    }

    public E pop() {
        elementCount--;
        E e = peek();
        return e;
    }

    /**
     * 查看栈顶元素而不弹出
     *
     * @return
     */
    public synchronized E peek() {
        if (elementCount <= 0) {
            throw new EmptyStackException();
        }
        E e = (E) elements[elementCount];
        return e;
    }

    private void addElement(E e) {
        ensureCapacity(elementCount + 1);
        elements[elementCount++] = e;
    }

    /**
     * 扩容,线程安全问题？
     *
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity) {
        if ((minCapacity - elements.length) >= 0) {
            int capacity = elementCount + increaseStep;
            Object[] newObj = new Object[capacity];
            System.arraycopy(elements, 0, newObj, 0, elementCount);
            elements = newObj;
        }
    }

    /**
     * 线程安全问题
     */
    private void iterator() {

    }


    public static void main(String[] args) {
        Code03_Array2Stack code03_array2Stack = new Code03_Array2Stack(10, 10);

        for (int i = 0; i < 21; i++) {
            code03_array2Stack.push(i);
            System.out.println("data:" + i);
        }
        for (int i = 0; i < 22; i++) {
            System.out.println("pop:" + code03_array2Stack.pop());
        }
    }

}
