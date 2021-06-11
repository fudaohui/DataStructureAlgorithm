package com.fdh.algorithm.day03;


import com.fdh.algorithm.util.ArrayUtil;

import java.util.Arrays;

import static com.fdh.algorithm.util.ArrayUtil.*;
import static com.fdh.algorithm.util.ArrayUtil.printArray;

/**
 *
 */
public class PartionionSort {


    /**
     * 根据给定的数据，将数据中小于target放到数据左边，大于target的放到右边
     * 左右两边可以无序
     *
     * @param arr
     * @param target
     */
    public static void partion1(int[] arr, int target) {

        int lessThanIndex = -1;
        int index = 0;
        while (index < arr.length) {
            if (arr[index] <= target) {
                swap(arr, index, ++lessThanIndex);
            }
            index++;
        }
    }

    /**
     * 根据给定的数组，和目标值，把小于targer的放左边，大于target的放右边，等于target的放中间
     * 荷兰国旗问题
     * 时间复杂度O(n)
     *
     * @param arr
     * @param target
     */
    public static int[] partion2(int[] arr, int l, int r, int target) {

        int lessIndex = l - 1;
        int greaterIndex = r + 1;
        int index = l;
        int count = 0;
        while (index < greaterIndex) {
            if (arr[index] < target) {
                swap(arr, index++, ++lessIndex);
            } else if (arr[index] > target) {
                swap(arr, index, --greaterIndex);
            } else {
                index++;
            }
        }
        return new int[]{lessIndex, greaterIndex};

    }


    /**
     * 快速排序 时间复杂度 O（N*logN）,O(logN)->记录 [l-lessThan,lessThan+1],[moreThan,r]
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int target = arr[l + ((r - l) >> 1)];
        int[] ints = partion2(arr, l, r, target);
        quickSort(arr, l, ints[0]);
        quickSort(arr, ints[1], r);
    }


    public static void main(String[] args) {

//        int[] a = {0, 5, 4, 3, 2};
//        int[] a = {5, 4, 3, 2, 1, 0};
//        int[] a = {5, 3, 2, 3, 2};
//        int[] a = {5, 3, 2, 3, 2, 10, 3, 1, 0, 11};
//        int[] a = {1,2,3,4,5};
//        partion2(a, 0, a.length - 1, 3);
//        quickSort(a, 0, a.length - 1);
//        ArrayUtil.printArray(a);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generatorRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1, 0, arr1.length - 1);
            Arrays.sort(arr2);
            if (!isArrayEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }
}
