package com.fdh.algorithm.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的宽度优先遍历
 */
public class Code03_LevelTravelBT {


    public static void levelTranvel(BTNode head) {

        Queue<BTNode> btNodeQueue = new LinkedList<>();
        btNodeQueue.add(head);
        while (!btNodeQueue.isEmpty()) {
            BTNode cur = btNodeQueue.poll();
            System.out.print(cur.getValue() + ",");

            if (cur.getLeft() != null) {
                btNodeQueue.add(cur.getLeft());
            }
            if (cur.getRight() != null) {
                btNodeQueue.add(cur.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getRight().setLeft(new BTNode(6));
        head.getRight().setRight(new BTNode(7));
        levelTranvel(head);
    }
}
