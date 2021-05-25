package com.fdh.algorithm.day01;


import static com.fdh.algorithm.day01.Code03_InsertSort.insertSort;
import static com.fdh.algorithm.util.ArrayUtil.generatorRandomArray;
import static com.fdh.algorithm.util.ArrayUtil.printArray;

/**
 * 无序数组，相邻不相等。局部最小问题（二分法）
 * <p>
 * 局部最小问题：给定一个无序数组，已知任意两个相邻元素不等，如a[0] < a[1]
 * a[n-2] < a[n-1],或则a[i] < a[i-1],a[i] < a[i+1]（i!=0&& i!=n-1）,0,n-2，i均为局部最小
 * 注：实际上任意一个数组都存在局部最小问题（要么一直掉头向下；要么一直掉头向上；要么中间有个”对号“的起伏；没有第三种可能）
 * 二分法的实质：只有能构建出一种排它的逻辑且这种逻辑是正确的就可以二分
 * 为什么此题可以二分？可用排除法就一定能二分
 * 二分法可以叫排除法
 */
public class Code06_ScopeMiniData {


    /**
     * 二分法局部最小问题求解
     *
     * @param arr
     * @return
     */
    public static int scopeMiniIndex(int[] arr) {
        int index = -1;
        if (arr == null || arr.length < 1) {
            return index;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 2] < arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int mid = 0;
        int leftIndex = 1;
        int rightIndex = arr.length - 2;

        while (leftIndex <= rightIndex) {
            mid = leftIndex + ((rightIndex - leftIndex) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                rightIndex = mid - 1;
            } else if (arr[mid] > arr[mid - 1]) {
                leftIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 20;
        int maxValue = 100;
        int[] arr1 = generatorRandomArray(maxSize, maxValue);
//        insertSort(arr1);
        printArray(arr1);
        int scopeMiniIndex = scopeMiniIndex(arr1);
        System.out.println(scopeMiniIndex);
    }
}
