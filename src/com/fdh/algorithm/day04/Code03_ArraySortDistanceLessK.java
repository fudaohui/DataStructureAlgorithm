package com.fdh.algorithm.day04;


import com.fdh.algorithm.util.ArrayUtil;

import java.util.PriorityQueue;

/**
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，
 * 每个元素移动的距离一定不超过k，并且k相对于数组长度来说是比较小的。
 */
public class Code03_ArraySortDistanceLessK {

    public static void sort(int[] arr, int k) {

        //整数默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int index = 0;
        int max = Math.max(arr.length, k);
        //前K个元素先排好序，小到大
        for (; index < max; index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        //剩余的元素
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }

    }


    public static void main(String[] args) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//
//        heap.add(8);
//        heap.add(4);
//        heap.add(4);
//        heap.add(9);
//        heap.add(10);
//        heap.add(3);
//
//        while (!heap.isEmpty()) {
//            System.out.println(heap.poll());
//        }

        int[] a = {3,2,1,4,5,9,6,8,7};
        sort(a,5);
        ArrayUtil.printArray(a);
    }
}
