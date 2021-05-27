package com.fdh.algorithm.day02;


/**
 * 队列特点：先进先出，有固定大小（不考虑无界队列）
 * 队列的常见方法：add  ,remove ,size，isEmpty等
 * 这里不考虑 take put;offer,poll等时间属性操作，没有报错
 * 非生产可用队列
 * 这里应该可以扩容直到maxSize
 * <p>
 * 核心!::俩个指针，指示头尾
 */
public class Code05_Array2Quenue<T> {
    /**
     * 队列最大长度
     */
    private int maxSize;
    /**
     * 数据的前指针，取
     */
    private int front;

    /**
     * 数组的后指针，放
     */
    private int rear;

    /**
     * 实际纯数据的
     */
    private Object[] elements;

    public Code05_Array2Quenue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
    }

    public void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("队列已满");
        }
        elements[rear++] = t;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("队列为空");
        }
        return (T) elements[front++];
    }

    public boolean isFull() {

        return rear > maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }


    public static void main(String[] args) {

        int maxSize = 20;
        Code05_Array2Quenue<Integer> integerCode05_array2Quenue = new Code05_Array2Quenue<Integer>(20);
        for (int i = 0; i < maxSize; i++) {
            integerCode05_array2Quenue.add(i);
        }

        for (int i = 0; i < maxSize + 2; i++) {
            System.out.println(integerCode05_array2Quenue.remove());
        }
    }
}
