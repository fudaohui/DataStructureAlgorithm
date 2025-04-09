package com.fdh.algorithm.leecode;


import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 */
public class ValidSymbol {


    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> chars = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(' || c == '{' || c == '[') {
                chars.push(c);
            } else {
                if (chars.isEmpty()){
                    return false;
                }
                char popped = chars.pop();
                if ((c == ')' && popped != '(')
                        || (c == '}' && popped != '{')
                        || (c == ']' && popped != '[')) {
                    return false;
                }
            }
        }
        return chars.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("(){}"));
        System.out.println(isValid("(}"));
    }
}
