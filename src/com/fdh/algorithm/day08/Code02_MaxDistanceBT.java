package com.fdh.algorithm.day08;

import com.fdh.algorithm.day07.BTNode;

/**
 * 求二叉树的点到点最大距离
 * <p>
 * 思路：先序遍历法，1、计算左树的最大深度；2、计算右树的最大深度；3，计算该节点的为头的最大深度，（求最大值）
 * 4、和上一次的得到的距离（深度）比较求最大值
 * 总结：动态规划的思想
 */
public class Code02_MaxDistanceBT {


    static class Info {
        public int height;
        public int maxDistance;

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public static int computerBTMaxDistance(BTNode head) {

        if (head == null) {
            return 0;
        }
        return process(head).maxDistance;
    }


    private static Info process(BTNode btNode) {
        if (btNode == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(btNode.getLeft());//左树高度和最大距离
        Info leftInfo2 = process(btNode.getRight());//左树高度和最大距离
        int height = Math.max(leftInfo.height, leftInfo2.height) + 1;//此节点为父的高度
        int maxDistance = Math.max(leftInfo.height + leftInfo2.height + 1, Math.max(leftInfo.maxDistance, leftInfo2.maxDistance));
        return new Info(height, maxDistance);
    }


    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setRight(new BTNode(2));
        head.getRight().setLeft(new BTNode(93));
        head.getRight().getLeft().setRight(new BTNode(100));
//        head.setRight(new BTNode(3));
//        head.getLeft().setLeft(new BTNode(4));
//        head.getLeft().setRight(new BTNode(5));
//        head.getLeft().getRight().setRight(new BTNode(5));
//        head.getRight().setRight(new BTNode(8));


        System.out.println(computerBTMaxDistance(head));

    }
}
