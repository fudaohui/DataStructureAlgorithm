package com.fdh.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumZero {

    public static ArrayList<List<Integer>> threeNum(int[] src) {

        ArrayList<List<Integer>> rest = new ArrayList<>();
        if (src == null || src.length < 3) {
            return rest;
        }
        Arrays.sort(src);
        int leftIndex = 0;
        int rightIndex = src.length - 1;
        int sum = 0;
        for (int i = 0; i < src.length - 2; i++) {
            if (src[i] > 0) {
                break;
            }
            leftIndex = i + 1;
            while (leftIndex < rightIndex) {
                sum = src[i] + src[leftIndex] + src[rightIndex];
                if (sum < 0) {
                    leftIndex++;
                } else if (sum > 0) {
                    rightIndex--;
                } else {
                    rest.add(Arrays.asList(src[i], src[leftIndex], src[rightIndex]));
                    leftIndex++;
                    rightIndex--;
                }
            }

        }

        return rest;
    }

    public static void main(String[] args) {

        int[] src = {-1, 0, -1, 2, -3, -2};
        ArrayList<List<Integer>> lists = threeNum(src);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
