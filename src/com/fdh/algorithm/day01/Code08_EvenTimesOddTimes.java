package com.fdh.algorithm.day01;

/**
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 */
public class Code08_EvenTimesOddTimes {


    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次，假设a,b
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //计算完成后其实eor=a^b，a,b不同。eor必然有1，因此可以根据这个1，把数据分为两部分
        //奇数次b,偶数次其他

        int eorRightOne = eor & (~eor + 1);
        int onlyone = 0;
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if ((i1 & eorRightOne) != 0) {
                onlyone ^= i1;
            }
        }

        System.out.println(onlyone + " " + (eor ^ onlyone));

    }


    /**
     * 如何计算一个整数的二进制形式有多少个1
     *
     * @param data
     * @return
     */
    public static int bit1counts(int data) {

        int count = 0;

        while (data != 0) {
            //获取二进制形式最右侧的1，其他位置都清0
            int rightOne = data & ((~data) + 1);
            count++;
            //data的最右侧1置0，其他保持不变，若该数据不为0，继续获取下一个最右侧1
            data ^= rightOne;
        }
        return count;
    }

    public static void main(String[] args) {


//        int[] a = {5, 5, 6, 6, 6};
//        printOddTimesNum1(a);
        int[] a1 = {5, 5, 5, 6, 6, 6};
//        printOddTimesNum1(a1);
        printOddTimesNum2(a1);

//        Integer a = 255;
//        int bit1counts = bit1counts(255);
//        System.out.println(bit1counts);
    }
}
