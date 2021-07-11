package com.fdh.algorithm.day08;

import com.fdh.algorithm.day07.BTNode;
import com.fdh.algorithm.day07.Code06_PrintBT;

/**
 * 求一个二叉树的最大二叉搜索子树，返回Head
 * BST定义：
 * 二叉搜索树或者是一棵空树，或者是具有下列性质的二叉树：
 * （1）若左子树不空，则左子树上所有结点的值均小于或等于它的根节点的值；
 * （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 * （3）左、右子树也分别为二叉搜索树；
 * <p>
 * 处理此问题可能情况：
 * 1）以X节点满足二叉搜索子树
 * 2）以x节点左或右子树满足二叉搜所子树
 * 3）上述2情况最终会成为1条件，x节点走完，记录以x节点
 * 是否是二叉搜所树；二叉搜索子树的大小；二搜树最大值（x为别人左树时）；二叉树最小值（x为别人右树时候）
 */
public class Code03_MaxSubBST {

    /**
     * 以x为头节点，BST信息
     */
    static class XBSTTreeInfo {
        public BTNode maxSUbBHead;//BST头节点
        public int maxSUbBSTSize;//最大二搜节点数量
        public int min;//right sub tree最小值
        public int max;//left sub tree最大值

        public XBSTTreeInfo(BTNode maxSUbBHead, int maxSUbBSTSize, int min, int max) {
            this.maxSUbBHead = maxSUbBHead;
            this.maxSUbBSTSize = maxSUbBSTSize;
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "XBSTTreeInfo{" +
                    "head=" + maxSUbBHead == null ? "null" : maxSUbBHead +
                    ", maxSUbBSTSize=" + maxSUbBSTSize +
                    ", min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    public static XBSTTreeInfo maxBSTInfo(BTNode btNode) {

        if (btNode == null) {
            return null;
        }
        return process(btNode);
    }

    private static XBSTTreeInfo process(BTNode xbtNode) {

//         BTNode head;//BST头节点
//         int maxSUbBSTSize;//最大二搜节点数量
//         int min;//right sub tree最小值
//         int max;//left sub tree最大值
        if (xbtNode == null) {
            return null;
        }
        XBSTTreeInfo left = process(xbtNode.left);
        XBSTTreeInfo right = process(xbtNode.right);
        int max = xbtNode.value;
        int min = xbtNode.value;
        BTNode maxSubBSTHead = null;
        int maxSUbBSTSize = 0;
        //1、求以x为节点的树的最大最小值
        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
            maxSubBSTHead = left.maxSUbBHead;
            maxSUbBSTSize = left.maxSUbBSTSize;
        }
        if (right != null) {
            max = Math.max(right.max, max);
            min = Math.max(right.min, min);
            if (maxSUbBSTSize < right.maxSUbBSTSize) {//右子树最大二搜大
                maxSUbBSTSize = right.maxSUbBSTSize;
                maxSubBSTHead = right.maxSUbBHead;
            }
        }
        //求x为头满足二搜的条件
        //左右同时为空；左右同时满足二搜；左右任何一个满足二搜
        if ((left == null ? true : (left.maxSUbBHead == xbtNode.left && left.max < xbtNode.value))
                && (right == null ? true : (right.maxSUbBHead == xbtNode.right && right.min > xbtNode.value))) {//叶子节点，也是BST
            maxSubBSTHead = xbtNode;
            maxSUbBSTSize = (left == null ? 0 : left.maxSUbBSTSize) + (right == null ? 0 : right.maxSUbBSTSize) + 1;
        }
        return new XBSTTreeInfo(maxSubBSTHead, maxSUbBSTSize, min, max);
    }


    /**
     * 叶子节点是最大BST
     *
     * @return
     */
    public static BTNode subBST1() {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getRight().setLeft(new BTNode(6));
        head.getRight().setRight(new BTNode(7));
        return head;
    }

    /**
     * 头是最大BST
     *
     * @return
     */
    public static BTNode subBST2() {
        BTNode head = new BTNode(5);
        head.setLeft(new BTNode(3));
        head.setRight(new BTNode(10));
//        head.getLeft().setLeft(new BTNode(2));
//        head.getLeft().setRight(new BTNode(4));
//        head.getRight().setLeft(new BTNode(6));
//        head.getRight().setRight(new BTNode(11));
        return head;
    }


    /**
     * 头是最大BST
     *
     * @return
     */
    public static BTNode subBST3() {
        BTNode head = new BTNode(0);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(5));
        head.getLeft().setLeft(new BTNode(1));
        head.getLeft().setRight(new BTNode(3));
        head.getLeft().getRight().setLeft(new BTNode(4));
        head.getRight().setRight(new BTNode(6));
        return head;
    }

    public static void main(String[] args) {

//        System.out.println(maxBSTInfo(subBST1()));
//        BTNode node = subBST2();
        BTNode node = subBST3();
//        Code06_PrintBT.printBT(node);
        System.out.println(maxBSTInfo(node).maxSUbBHead.value);
    }
}
