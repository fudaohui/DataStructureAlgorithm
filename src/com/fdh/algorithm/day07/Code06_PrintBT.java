package com.fdh.algorithm.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 打印一颗二叉树，这里打印的方法是顺时针90度旋转打印，
 * 即先把二叉树选择90度，从上到下依次打印，可以观察到println的顺序
 * 依次为：{7，3，6，1，5，2，4}，实际上是“右头左”遍历树，和前序遍历打印
 * 注：
 * 1、注意遍历的时候也可以拿到节点所在树的深度，便于空格填充
 * 2、该打印方法暂时不考虑超长数据
 */
public class Code06_PrintBT {


    static class BTNodedepth {
        Integer value;//节点的值
        Integer depth;//此节点的深度

        public void setDepth(Integer depth) {
            this.depth = depth;
        }

        public Integer getDepth() {
            return depth;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static void printBT(BTNode header) {
//        int btDepth = Code04_TreeMaxWidthAndDepth.countBTDepth(header);
//        int width = Code04_TreeMaxWidthAndDepth.countTreeMaxWidth(header);

        Queue<BTNodedepth> btNodedepths = new LinkedList<>();

        rightHeadLeftRtravelBT(header, 1, btNodedepths);
        int size = btNodedepths.size();
        for (int i = 0; i < size; i++) {
            BTNodedepth btNodedepth = btNodedepths.poll();
            mprint(btNodedepth.getDepth(), btNodedepth.getValue());
        }
    }

    public static void mprint(int depth, int v) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 1; i < depth; i++) {
            stringBuilder.append("  ");
        }
        String toString = stringBuilder.append(v).toString();
        System.out.println(toString);
    }

    //右，头，左遍历收集节点数据
    public static void rightHeadLeftRtravelBT(BTNode header, int depth, Queue<BTNodedepth> btNodedepthQueue) {
        if (header == null) {
            return;
        }
        rightHeadLeftRtravelBT(header.getRight(), depth + 1, btNodedepthQueue);//中序遍历右子树
        BTNodedepth btNodedepth = new BTNodedepth();
        btNodedepth.setValue(header.getValue());
        btNodedepth.setDepth(depth);
        btNodedepthQueue.add(btNodedepth);
        rightHeadLeftRtravelBT(header.getLeft(), depth + 1, btNodedepthQueue);//中序遍历右子树

    }

    /**
     * 打印结果
     *     7
     *   3
     *     6
     * 1
     *     5
     *   2
     *     4
     * @param args
     */
    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getRight().setLeft(new BTNode(6));
        head.getRight().setRight(new BTNode(7));

//        Queue<BTNodedepth> btNodes = new LinkedList<>();
//        rightHeadLeftRtravelBT(head, btNodes);
//
//        for (BTNodedepth btNodedepth : btNodes) {
//            System.out.print(btNodedepth.getValue() + "-" + btNodedepth.getDepth() + ",");
//        }

        printBT(head);
    }
}
