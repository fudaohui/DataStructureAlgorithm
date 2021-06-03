package com.fdh.algorithm.day03;

/**
 * 归并排序
 * <p>
 * 二分，递归，合并
 */
public class Code02_MergeSort {


    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }


    /**
     * @param arr
     * @param leftIndex
     * @param rightIndex
     */
    private static void process(int[] arr, int leftIndex, int rightIndex) {

        //递归推出条件
        if (leftIndex == rightIndex) {
            return;
        }
        int midIndex = leftIndex + (rightIndex - leftIndex) >> 1;
        process(arr, leftIndex, midIndex);
        process(arr, midIndex + 1, rightIndex);
        merge1(arr, leftIndex, midIndex, rightIndex);
    }

    private static void merge1(int[] arr, int leftIndex, int midIndex, int rightIndex) {
        int[] temp = new int[rightIndex - leftIndex + 1];
        int i = 0;
        int p1 = leftIndex;
        int p2 = midIndex + 1;
        //mid 左右连边有序,那边小，index就近1逼近直到>=
        if (p1 <= midIndex && p2 <= rightIndex) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        if (p1 <= midIndex) {
            temp[i++] = arr[p1++];
        }
        if (p2 <= rightIndex) {
            temp[i++] = arr[p2++];
        }
        //temp倒腾到arr
        for (int j = 0; j < temp.length; j++) {
            arr[leftIndex + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 4};
        mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }
    }
}
