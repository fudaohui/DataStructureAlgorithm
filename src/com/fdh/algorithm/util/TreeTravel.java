package com.fdh.algorithm.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTravel {


    public static void postTravel(TreeNode treeNode, List<Integer> result) {

        List<Integer> ret = new ArrayList<>();
        if (treeNode == null) {
            return;
        }
        postTravel(treeNode.left, result);
        postTravel(treeNode.right, result);
        result.add(treeNode.val);
    }


    public static List<Integer> postTravelStack(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode popped = stack.pop();
            linkedList.addFirst(popped.val);
            if (popped.left != null) {
                stack.push(popped.left);
            }
            if (popped.right != null) {
                stack.push(popped.right);
            }
        }

        return linkedList;
    }

    public static void main(String[] args) {
//        int[] src={1,2,3,4,5,6,7,8};
//        List<int[]> list = Arrays.asList(src);

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode1_f = new TreeNode(2);
        TreeNode treeNode1_r = new TreeNode(3);
        treeNode1.left = treeNode1_f;
        treeNode1.right = treeNode1_r;

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        postTravel(treeNode1,arrayList);
        List<Integer> list = postTravelStack(treeNode1);
//
        for (Integer i : list) {
            System.out.println(i);
        }

    }


}
