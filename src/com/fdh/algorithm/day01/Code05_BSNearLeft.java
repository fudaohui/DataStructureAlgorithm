package com.fdh.algorithm.day01;

import com.fdh.algorithm.util.ArrayUtil;

import static com.fdh.algorithm.day01.Code03_InsertSort.insertSort;
import static com.fdh.algorithm.util.ArrayUtil.generatorRandomArray;

/**
 * 在一个有序数组中，找>=某个数最左侧的位置
 */
public class Code05_BSNearLeft {


    /**
     * 在一个有序数组中，找>=某个数最左侧的位置
     *
     * @param arr
     * @param target
     * @return
     */
    public static int nearestLeftIndex(int[] arr, int target) {
        int index = -1;
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int mid = 0;
        while (leftIndex <= rightIndex) {
            mid = leftIndex + ((rightIndex - leftIndex) >> 1);
            if (arr[mid] >= target) {
                index = mid;
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
        return index;
    }

    public static int test(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

//        int[] a = {9, 21, 22, 27, 34, 34, 40, 56, 62, 77, 81, 88};
//        int nearestLeftIndex = nearestLeftIndex(a, 9);
//        int nearestLeftIndex = test(a, 30);
//        System.out.println("nearestLeftIndex:" + nearestLeftIndex + " v:" + a[nearestLeftIndex]);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            insertSort(arr1);
            int value = (int) ((maxValue + 1) * Math.random());
            if (nearestLeftIndex(arr1, value) != test(arr1, value)) {
                ArrayUtil.printArray(arr1);
                System.out.println(value);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
