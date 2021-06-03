package com.fdh.algorithm.day03;

import com.fdh.algorithm.util.ArrayUtil;

/**
 * 归并排序
 * <p>
 * 二分，递归，合并
 */
public class Code02_MergeSort {


    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }


    /**
     * @param arr
     * @param leftIndex
     * @param rightIndex
     */
    private static void process(int[] arr, int leftIndex, int rightIndex) {

        //递归推出条件
        if (leftIndex == rightIndex) {
            return;
        }
        int midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
        process(arr, leftIndex, midIndex);
        process(arr, midIndex + 1, rightIndex);
        merge(arr, leftIndex, midIndex, rightIndex);
    }

    private static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {
        int[] temp = new int[rightIndex - leftIndex + 1];
        int i = 0;
        int p1 = leftIndex;
        int p2 = midIndex + 1;
        //mid 左右连边有序,那边小，index就近1逼近直到>=
        while (p1 <= midIndex && p2 <= rightIndex) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        if (p1 <= midIndex) {
            temp[i++] = arr[p1++];
        }
        if (p2 <= rightIndex) {
            temp[i++] = arr[p2++];
        }
        //temp倒腾到arr
        for (int j = 0; j < temp.length; j++) {
            arr[leftIndex + j] = temp[j];
        }
    }

    // 非递归方法实现
    public static void mergeSort2(int[] arr) {


        int step = 1;
        while (step < arr.length) {
            int leftIndex = 0;
            int midIndex = 0;
            int rightIndex = 0;
            step *= 2;
            for (int j = 0; j < arr.length / step; j++) {
                leftIndex = j * step;
                rightIndex = (j + 1) * step - 1;
                if ((arr.length - 1 - rightIndex) < step) {//不够一个步长了
                    rightIndex = arr.length - 1;
                }
                //判断
                midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
                merge(arr, leftIndex, midIndex, rightIndex);
            }
        }

    }

    public static void main(String[] args) {


        int[] a = {8, 5, 4, 6,2};
        int[] copyArray = ArrayUtil.copyArray(a);
        mergeSort(a);
        mergeSort2(copyArray);
        ArrayUtil.printArray(a);
        ArrayUtil.printArray(copyArray);
//        int maxSize = 20;
//        int maxValue = 22;
//        for (int i = 0; i < 50000; i++) {
//            int[] randomArray = ArrayUtil.generatorRandomArray(maxSize, maxValue);
//            int[] copyArray = ArrayUtil.copyArray(randomArray);
//            mergeSort(randomArray);
//            mergeSort2(copyArray);
//            if (!ArrayUtil.isArrayEqual(randomArray, copyArray)) {
//                System.out.println("完蛋了");
//                ArrayUtil.printArray(randomArray);
//                ArrayUtil.printArray(copyArray);
//                break;
//            }
//
//        }

    }
}
