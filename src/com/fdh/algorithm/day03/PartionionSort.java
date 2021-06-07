package com.fdh.algorithm.day03;


import com.fdh.algorithm.util.ArrayUtil;

/**
 *
 */
public class PartionionSort {


    /**
     * 根据给定的数据，将数据中小于target放到数据左边，大于target的放到右边
     *
     * @param arr
     * @param target
     */
    public static void partion(int[] arr, int target) {

        int lessThanIndex = -1;
        int index = 0;
        while (index < arr.length) {
            if (arr[index] <= target) {
                ArrayUtil.swap(arr, index, ++lessThanIndex);
            }
            index++;
        }
    }


    public static void main(String[] args) {

//        int[] a = {0, 5, 4, 3, 2, 1, 2};
        int[] a = {5,4,3,2,1};
//        int[] a = {1,2,3,4,5};
        partion(a, 3);
        ArrayUtil.printArray(a);
    }
}
