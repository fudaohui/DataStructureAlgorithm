package com.fdh.algorithm.day03;

import java.util.TreeSet;

/**
 * 求数组arr[L..R]中的最大值.
 * 核心：二分法，递归
 * 递归思想：大事化小，小事化了
 */
public class Code01_GetL2RMaxFromArray {

    /**
     * 根据指定的范围，在此范围内查找最大值
     *
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public static int getMaxDataFromArray(int[] arr, int leftIndex, int rightIndex) {
        if ((leftIndex > rightIndex) || rightIndex >= arr.length) {
            throw new IllegalArgumentException("leftIndex, rightIndex");
        }
        if (leftIndex == rightIndex) {
            return arr[leftIndex];
        }
        int midIndex = leftIndex + ((rightIndex - leftIndex) >> 2);
        int leftMax = getMaxDataFromArray(arr, leftIndex, midIndex);
        int rightMax = getMaxDataFromArray(arr, midIndex + 1, rightIndex);
        return leftMax > rightMax ? leftMax : rightMax;
    }

    public static void main(String[] args) {
//        int[] arr = {9, 9, 6, 4, 10, 3, 5, 7, 0};
//        System.out.println(getMaxDataFromArray(arr, 3, 5));


        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            int v = (int) (Math.random() * (10 + 1) * 10);
            System.out.println("insert v:" + v);
            integers.add(v);
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }


    }

}
