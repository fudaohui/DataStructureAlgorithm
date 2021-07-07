package com.fdh.algorithm.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 打印一颗二叉树，见图：二叉树打印顺时针旋转.jpg
 * 采用右头左方式遍历，然后按照行打印
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
        int btDepth = Code04_TreeMaxWidthAndDepth.countBTDepth(header);
//        int width = Code04_TreeMaxWidthAndDepth.countTreeMaxWidth(header);

        Queue<BTNodedepth> btNodedepths = new LinkedList<>();

        rightHeadLeftRtravelBT(header, btNodedepths);

        for (int i = 0; i < btNodedepths.size(); i++) {
            BTNodedepth btNodedepth = btNodedepths.poll();
            mprint(btDepth - btNodedepth.getDepth(), btNodedepth.getValue());
        }
    }

    public static void mprint(int depth, int v) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            stringBuilder.append(" ");
        }
        String toString = stringBuilder.append(v).toString();
        System.out.println(toString);
    }

    //右，头，左遍历收集节点数据
    public static int rightHeadLeftRtravelBT(BTNode header, Queue<BTNodedepth> btNodedepthQueue) {
        if (header == null) {
            return 0;
        }
        int depth = rightHeadLeftRtravelBT(header.getRight(), btNodedepthQueue) + 1;//中序遍历右子树
        BTNodedepth btNodedepth = new BTNodedepth();
        btNodedepth.setValue(header.getValue());
        btNodedepth.setDepth(depth);
        btNodedepthQueue.add(btNodedepth);
        int depth1 = rightHeadLeftRtravelBT(header.getLeft(), btNodedepthQueue);//中序遍历右子树
        return Math.max(depth, depth1);

    }

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
