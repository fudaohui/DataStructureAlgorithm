package com.fdh.algorithm.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值的两个整数，并返回它们的数组下标。
     * 假设每种输入只会对应一个答案，且同一个元素不能使用两次
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：nums[0] + nums[1] = 2 + 7 = 9
     *
     * @param src
     * @param target
     * @return
     */
    public static int[] twoNum(int[] src, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < src.length; i++) {
            int j = target - src[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            }
            map.put(src[i], i);
        }
        return new int[0];

    }


    public static int[] twoNum2(int[] src, int target) {

        for (int i = 0; i < src.length; i++) {
            int i1 = src[i];
            for (int j = 0; j < src.length; j++) {
                int i2 = src[j];
                if ((i1 + i2) == target) {
                    return new int[]{i1, i2};
                }
            }
        }

        return new int[0];

    }

    public static void main(String[] args) {
        int[] src = {0, 1, 2, 3, 4, 5, 7, 12, 8};
//        Arrays.sort();
        System.out.printf(Arrays.toString(twoNum(src, 1)));
        System.out.printf(Arrays.toString(twoNum2(src, 1)));
//        System.out.printf(Arrays.toString(twoNum(src,100)));
    }
}
