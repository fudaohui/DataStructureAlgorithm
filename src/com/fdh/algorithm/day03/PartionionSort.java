package com.fdh.algorithm.day03;


import com.fdh.algorithm.util.ArrayUtil;

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
                ArrayUtil.swap(arr, index, ++lessThanIndex);
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
    public static void partion2(int[] arr, int target) {

        int lessThanIndex = -1;
        int index = 0;
        while (index < arr.length) {
            if (arr[index] < target) {
                ArrayUtil.swap(arr, index++, ++lessThanIndex);
            } else if (arr[index] == target) {
                ArrayUtil.swap(arr, index, lessThanIndex);
            }
        }
    }


    public static void main(String[] args) {

//        int[] a = {0, 5, 4, 3, 2, 1, 2};
        int[] a = {5, 4, 3, 2, 3};
//        int[] a = {1,2,3,4,5};
        partion2(a, 3);
        ArrayUtil.printArray(a);
    }
}
