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


    public static int computerBTMaxDistance(BTNode head) {

        if (head == null) {
            return 0;
        }
        return process(head.getLeft());
    }

    private static int process(BTNode btNode) {
        if (btNode == null) {
            return 0;
        }
        int maxDistance1 = process(btNode.getLeft());
        int maxDistance2 = process(btNode.getRight());
        int a = maxDistance1 + maxDistance2 + 1;
        return Math.max(a, 0);
    }

    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getLeft().getRight().setRight(new BTNode(5));
        head.getRight().setRight(new BTNode(8));


        System.out.println(computerBTMaxDistance(head));

    }
}
