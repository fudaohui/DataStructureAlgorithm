package com.fdh.algorithm.leecode;


/**
 * 爬楼梯问题
 * 问题：假设你正在爬楼梯。需要爬 n 个台阶才能到达楼顶。每次你可以爬 1 或 2 个台阶。问有多少种不同的方法可以爬到楼顶？
 * <p>
 * 输入：n = 2 → 输出：2（1+1 或 2）
 * 输入：n = 3 → 输出：3（1+1+1，1+2，2+1）
 */
public class TwoSteepStairs {


    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre1 = 2;//f(n-1)
        int pre2 = 1;//f(n-2)
        int cur = 0;

        //f(n)=f(n-1)+f(n-2)
        for (int i = 3; i <= n; i++) {
            cur = pre1 + pre2;//当前问题求解的是上上一个问题子集+上一个问题子集
            pre2 = pre1;//上上一个问题子集，移动到上一个
            pre1 = cur;// 上一个问题子集移动到当前
        }
        return pre1;
    }


    public static int climbStairs2(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs2(n - 2) + climbStairs2(n - 1);
    }


    public static void main(String[] args) {

        System.out.println(climbStairs(10));
        System.out.println(climbStairs2(10));
    }
}
