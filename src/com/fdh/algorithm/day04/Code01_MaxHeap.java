package com.fdh.algorithm.day04;

import com.fdh.algorithm.util.ArrayUtil;

/**
 * 大根堆的实现，已经暴力实现的比较器
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
            this.limit = limit + 1;
            heapArr = new int[limit + 1];
        }

        /**
         * 堆是否满
         *
         * @return
         */
        public boolean isFull() {
            return heapSize == limit - 1;
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
                fatherIndex = fatherIndex >> 1;
            }

        }

        public int pop() {
            int target = heapArr[1];
            //调整完全二叉树
            ArrayUtil.swap(heapArr, 1, heapSize--);
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
                ArrayUtil.swap(heapArr, curIndex, largestIndex);
                curIndex = largestIndex;
                leftIndex = curIndex << 1;
                rightIndex = (curIndex << 1) + 1;
            }
            return target;
        }

    }


    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(10);
        for (int i = 1; i <= 10; i++) {
            maxHeap.push(i);
        }
        ArrayUtil.printArray(maxHeap.heapArr);

        System.out.println(maxHeap.pop());
        ArrayUtil.printArray(maxHeap.heapArr);

    }
}
