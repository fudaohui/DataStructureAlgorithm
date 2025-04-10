package com.fdh.algorithm.leecode;

import java.util.HashMap;

public class Solution {

    /**
     * 盛最多水的容器（双指针贪心）
     * 原题描述
     * 题目：给定一个非负整数数组 height，表示一系列竖直线的长度。选择其中两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水，返回最大容量。
     * 示例：
     * • 输入：height = [1,8,6,2,5,4,8,3,7]
     * • 输出：49
     * • 解释：选择第 2 条线（高度 8）和第 9 条线（高度 7），形成的容器宽度为 7，高度为 7，总容量为 7 * 7 = 49。
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int currArea;
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int currHeight = 0;
        int currWidth = 0;
        while (leftIndex < rightIndex) {

            currHeight = Math.min(height[leftIndex], height[rightIndex]);
            currWidth = rightIndex - leftIndex;
            currArea = currHeight * currWidth;
            //右指针向左没必要移动了，移动的结果是，宽度减小，高度要么更小，要么更高
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }

            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }


    // a b c a b d a b c d a f
    // 滑动窗口

    /**
     * 题目：给定一个字符串 s，找出其中不含有重复字符的 最长子串 的长度。
     * 示例：
     * • 输入：s = "abcabcbb"
     * • 输出：3
     * • 解释：最长无重复子串是 "abc"，长度为 3
     *
     * @param srcStr
     * @return
     */
    public static int maxLength(String srcStr) {

        if (srcStr == null) {
            return 0;
        }
        //f a d g d g a r a b h t u a s f a d a
        char[] charArray = srcStr.toCharArray();
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        for (; rightIndex < charArray.length; rightIndex++) {
            char c = charArray[rightIndex];
            if (charIndexMap.containsKey(c)) {
                //map中的旧数据可能没有移除
                leftIndex = Math.max(charIndexMap.get(c) + 1,leftIndex);
            }
            charIndexMap.put(c, rightIndex);
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);

//            System.out.println(charArray[leftIndex] + "--" + charArray[rightIndex]);
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) > left) {
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};


//        abcabcbbefadgdgarhtusfada
        String src = "fadgdgarabhtuasfada";
        System.out.println(maxLength(src) + "");
//        System.out.println(lengthOfLongestSubstring(src) + "");
    }
}
