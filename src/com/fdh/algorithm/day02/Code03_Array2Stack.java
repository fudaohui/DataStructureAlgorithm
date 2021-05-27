package com.fdh.algorithm.day02;

import java.util.EmptyStackException;

/**
 * 数组实现栈的简单实现，没有考虑栈最大深度，和数组弹性自增
 * <p>
 * 数组的特点：
 * 在内存中，数组是一块连续的区域。
 * 插入和删除数据效率低（插入数据时，这个位置后面的数据都要后移）
 * 查询效率很高。因为数组是连续的，知道每一个数据的内存地址，可以直接找到给地址的数据(直接索引就能实现，不需要重头遍历)。
 * 不利于扩展，一开始数组定义的空间不够时要重新定义数组。
 * <p>
 * 缺点：需要预先指定大小，必要时候需要扩容（数组拷贝），链表不需要
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
