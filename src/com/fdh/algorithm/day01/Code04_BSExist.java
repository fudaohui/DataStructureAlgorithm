package com.fdh.algorithm.day01;

import com.fdh.algorithm.util.ArrayUtil;

import static com.fdh.algorithm.day01.Code03_InsertSort.insertSort;
import static com.fdh.algorithm.util.ArrayUtil.generatorRandomArray;

/**
 * 在一个有序数组中，找某个数是否存在
 */
public class Code04_BSExist {
    /**
     * 在有序的arr中查找targer，二分法
     *
     * @param arr
     * @param target
     * @return
     */
    public static boolean exist(int[] arr, int target) {

        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex = 0;
        while (leftIndex <= rightIndex) {
            midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
            if (arr[midIndex] == target) {
                return true;
            } else if (arr[midIndex] > target) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }
        return false;
    }

    // for test 对数器
    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            insertSort(arr1);
            int value = (int) ((maxValue + 1) * Math.random()) ;
            if (exist(arr1, value) != test(arr1, value)) {
                ArrayUtil.printArray(arr1);
                System.out.println(value);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


//        int[] a = {9, 21, 22, 27, 34, 34, 40, 56, 62, 77, 81, 88};
//        boolean exist = exist(a, 9);
//        System.out.println(exist);
    }
}
