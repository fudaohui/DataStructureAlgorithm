package com.fdh.algorithm.day07;

/**
 * 递归方式前序，中序，后序遍历二叉树
 */
public class Code01_RecursiveTravelBT {


    /**
     * 前序遍历：
     * 每个子树都是【头左（子数）右】
     *
     * @param head
     */
    public static void preOrderTravelBT(BTNode head) {
        if (head == null) {
            return;//递归退出条件
        }
        //先打印头
        System.out.print(head.getValue() + ", ");
        preOrderTravelBT(head.getLeft());//递归左子数
        preOrderTravelBT(head.getRight());//递归右子树
    }

    /**
     * 中序遍历
     * 每个子树都是【左（字数）头右（子数）】
     *
     * @param head
     */
    public static void middleOrderTravelBT(BTNode head) {
        if (head == null) {
            return;//递归退出条件
        }
        middleOrderTravelBT(head.getLeft());//中序遍历左子树
        System.out.print(head.getValue() + ", ");//打印节点
        middleOrderTravelBT(head.getRight());//中序遍历右子树
    }

    /**
     * 后续遍历
     * 每个子树都是先遍历左子树，然后右子树，最后头节点
     *
     * @param head
     */
    public static void postOrderTravelBT(BTNode head) {
        if (head == null) {
            return;//递归退出条件
        }
        postOrderTravelBT(head.getLeft());
        postOrderTravelBT(head.getRight());
        System.out.print(head.getValue() + ", ");//打印节点

    }

    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getRight().setLeft(new BTNode(6));
        head.getRight().setRight(new BTNode(7));
        preOrderTravelBT(head);
        System.out.println();
        middleOrderTravelBT(head);
        System.out.println();
        postOrderTravelBT(head);
    }
}
