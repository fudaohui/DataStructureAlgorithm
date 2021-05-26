package com.fdh.algorithm.day01;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * K，M问题：一个数组中有一种数出现K次，其他数都出现了M次，M > 1,  K < M，找到，出现了K次的数
 */
public class Code09_KM {

    /**
     * key  0~31 第i位为1的整数；v,count 出现的次数。
     * key 形如 1，2，4，8，16.key值32个，integer 32
     */
    public static HashMap<Integer, Integer> bitmap = new HashMap<>();

    /**
     * key : 2^0,2^1.......2^21;v,为2^0左移的偏移量
     */
    public static HashMap<Integer, Integer> initBitmap() {

        HashMap<Integer, Integer> bitmap = new HashMap<>();
        int k = 1;
        for (int i = 0; i < 32; i++) {
            bitmap.put(k, i);
            k <<= 1;
        }
        return bitmap;
    }


    // 请保证arr中，只有一种数出现了K次，其他数都出现了M次
    public static int onlyKTimes(int[] arr, int k, int m) {

        HashMap<Integer, Integer> bitmap = initBitmap();

        //下表对应Interget 1到31的偏移量，值为整个数组中满足在下表i的累加值。
        //假设第a[i]不为0，必然满足xm+k
        int[] a = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            while (num != 0) {
                int rightone = num & (-num);//寻找最右侧的1.等同于num & (~num+1)  //负数等于整数的反码+1；反码+1就是补码
                a[bitmap.get(rightone)]++;//数组中值二进制第i位不为1的话累加，若rightone为0拿不到数据
                num ^= rightone;//此位1清0，寻找下一个最右侧的1
                //while结束后该num每个位置的1都计数到对应下面的a中，循环下一个num
            }
        }

        int ktarget = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % m == k) {//xm+k，x多个
                ktarget |= (1 << i);
            }
        }

        //ktarget为0，表示可能真存在k个0，不不存在这样的数，需要排除
        if (ktarget == 0) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int i1 = arr[i];
                if (i1 == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }

        return ktarget;
    }

    /**
     * 对数期
     *
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int test(int[] arr, int k, int m) {

        Map<Integer, Integer> mmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (mmap.containsKey(i1)) {
                Integer count = mmap.get(i1);
                mmap.put(i1, count + 1);
            } else {
                mmap.put(i1, 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (mmap.containsKey(i1) && mmap.get(i1) == k) {
                return i1;
            }
        }
        return -1;
    }
    // [-range, +range]
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        // 真命天子出现的次数
        int times = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)) + 1);
        // 2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
//        int[] a = {6, 6, 6, 4, 4, 4, 5, 5, 5, 7, 7};
//
////        int onlyKTimes = onlyKTimes(a, 2, 3);
//        int onlyKTimes = test(a, 2, 3);
//        System.out.println(onlyKTimes);


        int kinds = 5;
        int range = 30;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");
    }

}
