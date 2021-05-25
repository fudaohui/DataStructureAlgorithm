package com.fdh.algorithm.day01;

import java.util.Arrays;

import static com.fdh.algorithm.util.ArrayUtil.*;
import static com.fdh.algorithm.util.ArrayUtil.printArray;

/**
 * 插入排序过程：
 * 假设前面 n-1(其中 n>=2)个数已经是排好顺序的，现将第 n 个数“插到“面已经排好的序列中，
 * 然后找到合适自己的位置，使得插入第n个数的这个序列也是排好顺序的。
 * 按照此法对所有元素进行插入，直到整个序列排为有序的过程，称为"插入排序“
 *
 * 时间复杂度计算：1+2+...(n-1)
 */
public class InsertSort {


    public static void insertSort(int[] arr) {

        if (arr == null && arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] a = new int[]{7, 6, 5, 9, 10, 4, 3, 100, 1};
//
//        insertSort(a);
//        for (int i = 0; i < a.length; i++) {
//            int i1 = a[i];
//            System.out.print(i1 + " ");
//
//        }

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertSort(arr1);
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
        insertSort(arr);
        printArray(arr);
    }
}
