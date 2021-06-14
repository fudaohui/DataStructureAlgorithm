package com.fdh.algorithm.day04;

import com.fdh.algorithm.util.ArrayUtil;

/**
 * 大根堆的实现，以及暴力实现的比较器
 * 大根堆定义：任意当前节点都比其叶子节点数据大则成为大根堆
 */
public class Code01_MaxHeap {

    public static class MaxHeap {
        /**
         * 数据大小，也是堆数据个数最大值
         */
        private int limit;

        /**
         * 堆结构的底层数据,0位置不使用
         */
        private int[] heapArr;

        /**
         * 当前堆数据个数
         */
        private int heapSize;

        public MaxHeap(int limit) {
            this.limit = limit;
            heapArr = new int[limit + 1];
        }

        /**
         * 堆是否满
         *
         * @return
         */
        public boolean isFull() {
            return heapSize == limit;
        }

        /**
         * 堆是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return heapSize == 0;
        }

        /**
         * 向堆中添加元素
         *
         * @param data
         */
        public void push(int data) {
            if (isFull()) {
                throw new RuntimeException("the heap is full!");
            }
            int curIndex = ++heapSize;
            heapArr[curIndex] = data;
            int fatherIndex = curIndex >> 1;
            while (fatherIndex >= 1 && heapArr[curIndex] > heapArr[fatherIndex]) {
                ArrayUtil.swap(heapArr, fatherIndex, curIndex);
                curIndex = fatherIndex;
                fatherIndex = curIndex >> 1;
            }

        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("the heap is empty!");
            }
            int target = heapArr[1];
            //调整完全二叉树
            ArrayUtil.swap(heapArr, 1, heapSize--);
            heapfy();
            return target;
        }

        private void heapfy() {
            //下沉
            int curIndex = 1;

            int leftIndex = curIndex << 1;
            int rightIndex = (curIndex << 1) + 1;
            int largestIndex;
            while (leftIndex < heapSize) {
                //左右子孩子比较
                largestIndex = (rightIndex <= heapSize) && heapArr[rightIndex] > heapArr[leftIndex] ? rightIndex : leftIndex;
                //父子比较
                largestIndex = heapArr[largestIndex] > heapArr[curIndex] ? largestIndex : curIndex;
                //可能死循环
                if (largestIndex == curIndex) {
                    break;
                }
                ArrayUtil.swap(heapArr, curIndex, largestIndex);
                curIndex = largestIndex;
                leftIndex = curIndex << 1;
                rightIndex = (curIndex << 1) + 1;
            }
        }


    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }

//    public static void main(String[] args) {
//
//        int value = 30;
//        int limit = 20;
//        int testTimes = 20;
//        for (int i = 0; i < testTimes; i++) {
//            int curLimit = (int) (Math.random() * limit) + 1;
//            MaxHeap my = new MaxHeap(curLimit);
//            RightMaxHeap test = new RightMaxHeap(curLimit);
//            int curOpTimes = (int) (Math.random() * limit);
//            for (int j = 0; j < curOpTimes; j++) {
//                if (my.heapSize != test.size) {
//                    System.out.println("size not equal ");
//                    return;
//                }
//                if (my.isEmpty()) {
//                    int curValue = (int) (Math.random() * value);
//                    my.push(curValue);
//                    test.push(curValue);
//                } else if (my.isFull()) {
//                    if (my.pop() != test.pop()) {
//                        System.out.println("pop Oops!");
//                    }
//                } else {
//                    if (Math.random() < 0.5) {
//                        int curValue = (int) (Math.random() * value);
//                        my.push(curValue);
//                        test.push(curValue);
//                    } else {
//                        if (my.pop() != test.pop()) {
//                            System.out.println("random pop Oops!");
//                        }
//                    }
//                }
//            }
//        }
//    }


    public static void main(String[] args) {

        int count = 20;
        MaxHeap maxHeap = new MaxHeap(count);
        for (int i = 0; i < count; i++) {
            maxHeap.push((int) (Math.random() * (count + 1)));
        }

        for (int i = 0; i < count; i++) {
            System.out.println(maxHeap.pop());
        }
    }
}
