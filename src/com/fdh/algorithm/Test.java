package com.fdh.algorithm;

public class Test {

    public static void sort(int[] src) {

        if (src == null || src.length <= 1) {
            return ;
        }
        int temp;
        for (int i = 0; i < src.length; i++) {
            for (int j = i; j < src.length; j++) {
                if (src[i] > src[j]) {
                    temp = src[i];
                    src[i] = src[j];
                    src[j] = temp;
                }

            }
        }

    }




    // 7 3 8 2 5 4 1
    public static void main(String[] args) {

        int[] src = {7 ,3, 8, 2 ,5, 4 ,1};

        sort(src);
        for (int i : src) {
            System.out.println(i);
        }

    }
}
