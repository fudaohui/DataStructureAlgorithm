package com.fdh.algorithm.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 获取二叉树的最大宽度
 * 方法：宽度优先遍历（队列），然后找到每一层的开始（或者结束）都可以，这里演示找结束
 */
public class Code04_TreeMaxWidthAndDepth {


    public static int countTreeMaxWidth(BTNode head) {
        if (head == null) {
            return 0;
        }
        Queue<BTNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(head);
        int max = 0;
        BTNode cueLevelEndNode = head;//当前层结束点
        BTNode nextLevelNode = null;
        int curLevelNotes = 0;
        while (!nodesQueue.isEmpty()) {
            BTNode btNode = nodesQueue.poll();//当前层
            curLevelNotes++;
            if (btNode.getLeft() != null) {
                nodesQueue.add(btNode.getLeft());//下一层
                nextLevelNode = btNode.getLeft();//下一层结束点不断向右漂移
            }
            if (btNode.getRight() != null) {//当前层
                nodesQueue.add(btNode.getRight());
                nextLevelNode = btNode.getRight();//直到飘到最右边的节点
            }
            //何时计算？队列吐出的节点等于当前层节点
            if (btNode == cueLevelEndNode) {
                cueLevelEndNode = nextLevelNode;
                max = Math.max(max, curLevelNotes);
                curLevelNotes = 0;
            }
        }
        return max;
    }

    /**
     * 求二叉树的最大深度
     *
     * @param header
     * @return
     */
    public static int countBTDepth(BTNode header) {
        if (header == null) {
            return 0;
        }
        return Math.max(countBTDepth(header.getLeft()), countBTDepth(header.getRight())) + 1;
    }

    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getRight().setLeft(new BTNode(6));
        head.getRight().setRight(new BTNode(7));
        System.out.println(countTreeMaxWidth(head));
        System.out.println(countBTDepth(head));
    }
}
