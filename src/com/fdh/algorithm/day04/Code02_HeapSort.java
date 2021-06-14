package com.fdh.algorithm.day04;

import com.fdh.algorithm.util.ArrayUtil;

import java.util.Arrays;

/**
 * 堆排序
 * 原理：先将数组变成大根堆，然后将1和N-1数据交换，交换后不满足大根堆，调整，然后1，N-2，循环上述步骤
 */
public class Code02_HeapSort {


    public static void heapSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        // O(N*logN)
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); // O(logN)
        }
        int heapSize = arr.length;
        ArrayUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapfy(heapSize, arr);
            ArrayUtil.swap(arr, 0, --heapSize);
        }
    }


    public static void heapInsert(int[] arr, int curIndex) {
        int fatherIndex = (curIndex-1) >> 1;
        while (fatherIndex >= 0 && arr[curIndex] > arr[fatherIndex]) {
            ArrayUtil.swap(arr, fatherIndex, curIndex);
            curIndex = fatherIndex;
            fatherIndex = (curIndex-1) >> 1;
        }
    }

    private static void heapfy(int heapSize, int[] arr) {
        //下沉
        int curIndex = 0;
        int leftIndex = (curIndex << 1) + 1;
        int rightIndex = (curIndex << 1) + 2;
        int largestIndex;
        while (leftIndex < heapSize) {
            //左右子孩子比较
            largestIndex = (rightIndex < heapSize) && arr[rightIndex] > arr[leftIndex] ? rightIndex : leftIndex;
            //父子比较
            largestIndex = arr[largestIndex] > arr[curIndex] ? largestIndex : curIndex;
            //可能死循环
            if (largestIndex == curIndex) {
                break;
            }
            ArrayUtil.swap(arr, curIndex, largestIndex);
            curIndex = largestIndex;
            leftIndex = (curIndex << 1) + 1;
            rightIndex = (curIndex << 1) + 2;
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < 1000000; i++) {
            int[] randomArray = ArrayUtil.generatorRandomArray(maxSize, maxValue);
            int[] copyArray = ArrayUtil.copyArray(randomArray);
            int[] copyArray2 = ArrayUtil.copyArray(randomArray);
            heapSort(randomArray);
            Arrays.sort(copyArray);
            if (!ArrayUtil.isArrayEqual(randomArray, copyArray)) {
                System.out.println("完蛋了");
                ArrayUtil.printArray(randomArray);
                ArrayUtil.printArray(copyArray);
                ArrayUtil.printArray(copyArray2);
                break;
            }

        }

//        int[] randomArray = {9,4,8,9,1,6,7,2,1,3};
//        heapSort(randomArray);
//        ArrayUtil.printArray(randomArray);
    }
}
