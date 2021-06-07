package com.fdh.algorithm.day03;

import com.fdh.algorithm.util.ArrayUtil;

/**
 * 数组小和问题：
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 方法：二分归并排序
 * 二分两边必定有序，无序就排序，在从左变一个数和右边第一个数比较，小于，后面都小于，求和
 */
public class Code03_SmallSum {


    /**
     * 求数组的小和
     *
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr) {

        if (arr == null || arr.length <= 0) {

            return 0;
        }
        return proccess(arr, 0, arr.length - 1);
    }

    /**
     * 计算l,r上的小和
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int proccess(int[] arr, int l, int r) {
        //递归推出条件，仅有一个数的时候
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        int leftSmallSum = proccess(arr, l, mid);
        int rightSmallSum = proccess(arr, mid + 1, r);
        int a = merge(arr, l, mid, r);
        return leftSmallSum + rightSmallSum + a;
    }

    /**
     * 求小和（伴随着排序，排序是必须的）
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private static int merge(int[] arr, int l, int mid, int r) {

        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int ret = 0;
        int i = 0;

        while (p1 <= mid && p2 <= r) {
            //mid两边已经是各自有序，小于的话计算小和，大于的不处理
            ret += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            //排序
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }

        for (int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
        return ret;
    }

    public static void main(String[] args) {


        //0+1+3++6+10
//        int[] a = {1, 2, 3};
//        int[] a = {1, 2, 3, 4, 5};
        int[] a = {1, 3, 2, 4, 5};
        System.out.println(smallSum(a));
        ArrayUtil.printArray(a);

    }
}
