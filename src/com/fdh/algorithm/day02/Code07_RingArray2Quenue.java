package com.fdh.algorithm.day02;

/**
 * 环形数组实现队列
 */
public class Code07_RingArray2Quenue<T> {
    /**
     * 队列（数组）最大范围
     */
    private int maxSize;
    /**
     * 前指针，取数据的index
     */
    private int front;
    /**
     * 追加数据的index
     */
    private int rear;

    /**
     * 当前数据量大小
     */
    private int curSize;

    private Object[] elements;

    public Code07_RingArray2Quenue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
    }

    public boolean isFull() {
        return curSize == maxSize;
    }

    public void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("队列已满");
        }
        elements[rear++] = t;
        rear = rear % maxSize;
        curSize++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("quenue is empty now!");
        }
        Object element = elements[front++];
        front = front % maxSize;
        curSize--;
        return (T) element;
    }


    public boolean isEmpty() {
        return maxSize == 0;
    }

    public static void main(String[] args) {
        int count = 5;
        Code07_RingArray2Quenue<Integer> integerCode07_ringArray2Quenue = new Code07_RingArray2Quenue<Integer>(count);
        for (int i = 0; i < count; i++) {
            integerCode07_ringArray2Quenue.add(i);//加满
        }

        while (true) {
            System.out.println(integerCode07_ringArray2Quenue.remove());
            integerCode07_ringArray2Quenue.add(count++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
