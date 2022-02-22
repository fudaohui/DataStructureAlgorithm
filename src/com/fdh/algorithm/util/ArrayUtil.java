package com.fdh.algorithm.util;

public class ArrayUtil {

    /**
     * 普通的比较与交换
     *
     * @param arr 原数据
     * @param i   数组地址i
     * @param j   数组地址j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void swap1(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * 随机数组发生器
     *
     * @param maxSize  数组的长度的最大范围
     * @param maxValue 数组的最大值
     * @return
     */
    public static int[] generatorRandomArray(int maxSize, int maxValue) {
        int arraySize = (int) (Math.random() * (maxSize + 1));
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (maxSize + 1));
        }
        return array;
    }

    public static void printArray(int[] arr) {
        if (arr == null || arr.length < 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i]).append(",");
        }
        System.out.println(stringBuffer.subSequence(0, stringBuffer.length() - 1).toString());
    }


    public static boolean isArrayEqual(int[] arr1, int[] arr2) {

        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 8, 10, 20, 6, 8, 7};
        int[] b = new int[]{9, 8, 11, 20, 6, 8, 7};

        printArray(a);
        System.out.println(isArrayEqual(a,b));

    }
}
