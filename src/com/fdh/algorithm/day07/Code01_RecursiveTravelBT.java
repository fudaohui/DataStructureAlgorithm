package com.fdh.algorithm.day07;

import com.fdh.algorithm.day02.Node;

/**
 * 递归方式前序，中序，后序遍历二叉树
 *
 * 先序：任何子树的处理顺序都是，先头节点、再左子树、然后右子树
 * 中序：任何子树的处理顺序都是，先左子树、再头节点、然后右子树
 * 后序：任何子树的处理顺序都是，先左子树、再右子树、然后头节点
 */
public class Code01_RecursiveTravelBT {


    /**
     * 前序遍历：
     * 每个子树都是【头左（子树）右】
     *
     * @param head
     */
    public static void preOrderTravelBT(BTNode head) {
        if (head == null) {
            return;//递归退出条件
        }
        //先打印头
        System.out.print(head.getValue() + ", ");
        preOrderTravelBT(head.getLeft());//递归左子树
        preOrderTravelBT(head.getRight());//递归右子树
    }

    /**
     * 中序遍历
     * 每个子树都是【左（子树）头右（子树）】
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
//        head.getLeft().setLeft(new BTNode(4));
//        head.getLeft().setRight(new BTNode(5));
//        head.getRight().setLeft(new BTNode(6));
//        head.getRight().setRight(new BTNode(7));
        head.getRight().setLeft(new BTNode(4));
        head.getRight().getLeft().setLeft(new BTNode(5));
        head.getRight().getLeft().setRight(new BTNode(6));

        BTNode head1 = new BTNode(8);
        head1.setLeft(new BTNode(9));
        head1.setRight(head);
//        preOrderTravelBT(head);
//        System.out.println();
        middleOrderTravelBT(head1);
//        System.out.println();
//        postOrderTravelBT(head);
    }
}
