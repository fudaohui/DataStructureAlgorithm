package com.fdh.algorithm.day01;

import com.fdh.algorithm.util.ArrayUtil;

import java.util.Arrays;

import static com.fdh.algorithm.util.ArrayUtil.*;

/**
 * 选择排序
 * <p>
 * 过程：
 * arr[0～N-1]范围上，选出最小值所在的位置，然后把最小值交换到0位置。
 * arr[1～N-1]范围上，选出最小值所在的位置，然后把最小值交换到1位置。
 * arr[2～N-1]范围上，选出最小值所在的位置，然后把最小值交换到2位置。
 * …
 * arr[N-1～N-1]范围上，找到最小值位置，然后把最小值交换到N-1位置。
 */
public class Code01_SelectionSort {


    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectSort(arr1);
            Arrays.sort(arr2);
            if (!isArrayEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generatorRandomArray(maxSize, maxValue);
//        printArray(arr);
//        selectSort(arr);
//        printArray(arr);
    }


    public static void selectSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    ArrayUtil.swap(arr, i, j);
                }
            }
        }
    }


}
