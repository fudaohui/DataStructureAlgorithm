package com.fdh.algorithm.day01;

import com.fdh.algorithm.util.ArrayUtil;

import java.util.Arrays;

import static com.fdh.algorithm.util.ArrayUtil.*;
import static com.fdh.algorithm.util.ArrayUtil.printArray;

/**
 * 过程：
 * arr[0～N-1]范围上，找到最小值所在的位置，然后把最小值交换到0位置。
 * arr[1～N-1]范围上，找到最小值所在的位置，然后把最小值交换到1位置。
 * arr[2～N-1]范围上，找到最小值所在的位置，然后把最小值交换到2位置。
 * …
 * arr[N-1～N-1]范围上，找到最小值位置，然后把最小值交换到N-1位置。
 * 重点：相邻比较，大数向后沉底
 * 时间复杂度计算：和选择相同
 */
public class Code02_BubbleSort {


    public static void bubbleSort(int[] arr) {

        if (arr == null && arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            Arrays.sort(arr2);
            if (!isArrayEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generatorRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);


//        int[] a = new int[]{7, 6, 5, 9, 10, 4, 3, 100, 1};
//
//        bubbleSort(a);
//        for (int i = 0; i < a.length; i++) {
//            int i1 = a[i];
//            System.out.println(i1+" ");
//
//        }
    }
}
