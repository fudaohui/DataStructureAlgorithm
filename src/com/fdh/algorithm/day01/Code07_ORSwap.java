package com.fdh.algorithm.day01;

import com.fdh.algorithm.util.ArrayUtil;
import org.omg.CORBA.INTERNAL;

/**
 * 亦或运算实现值交换,不使用额外变量
 * 注：有bug
 */
public class Code07_ORSwap {


    /**
     * 案例一：注意Integer不能引用传递，原因源码中value为final
     * 所以交换后值不变
     *
     * @param v1
     * @param v2
     */
    public static void swap(Integer v1, Integer v2) {
        v1 = v1 ^ v2;
        v2 = v1 ^ v2;
        v1 = v1 ^ v2;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {

//        int[] a = {1,2,3};
//        swap(a,0,1);
//        ArrayUtil.printArray(a);


//        show bug  两个引用一定不要相同！！！！！
//        int[] b = {2, 2, 3};
//        swap(b, 0, 0);
//        ArrayUtil.printArray(b);

        System.out.println(5^7^5);
    }
}
