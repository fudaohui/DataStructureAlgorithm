package com.fdh.algorithm.day03;


import com.fdh.algorithm.util.ArrayUtil;

import static com.fdh.algorithm.util.ArrayUtil.swap;

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
     *
     * @param arr
     * @param target
     */
    public static void partion2(int[] arr, int l, int r, int target) {

        int lessIndex = l - 1;
        int greaterIndex = r + 1;
        int index = l;
        while (index < greaterIndex) {
            if (arr[index] < target) {
                swap(arr, index++, ++lessIndex);
            } else if (arr[index] > target) {
                swap(arr, index, --greaterIndex);
            } else {
                index++;
            }
        }

    }


    public static void main(String[] args) {

        int[] a = {0, 5, 4, 3, 2};
//        int[] a = {5, 3, 2, 3, 2};
//        int[] a = {1,2,3,4,5};
        partion2(a, 0, a.length - 1, 3);
        ArrayUtil.printArray(a);
    }
}
