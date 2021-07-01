package com.fdh.algorithm.day07;

import java.util.Stack;

/**
 * 非递归方式实现先序，中序，后序遍历过程
 * 方法：需要使用额外的空间变量，栈
 */
public class Code02_unRecursiveTravelBT {

    /**
     * 前序遍历：
     * 1、弹出打印，头节点直接打印
     * 2、有右孩子，压栈
     * 3、有左孩子，压栈
     *
     * @param head
     */
    public static void preOrderTravelBT(BTNode head) {
        if (head == null) {
            return;
        }
        Stack<BTNode> mstack = new Stack<>();
        mstack.push(head);
        while (!mstack.isEmpty()) {
            BTNode btNode = mstack.pop();
            System.out.print(btNode.getValue() + ",");
            if (btNode.getRight() != null) {
                mstack.push(btNode.getRight());
            }
            if (btNode.getLeft() != null) {
                mstack.push(btNode.getLeft());
            }
        }
    }

    /**
     * 中序遍历：
     * 1、先走完左子树，依次放入栈中不弹出；
     * 2、当没有左子树了，弹出打印该节点；
     * 3、看此节点的右树，循环1步骤
     *
     * @param head
     */
    public static void middleOrderTravelBT(BTNode head) {

        Stack<BTNode> btNodeStack = new Stack<>();
        if (head != null) {
            while (!btNodeStack.isEmpty() || head != null) {
                if (head != null) { //head为空，左子树走完 1）
                    btNodeStack.push(head);
                    head = head.getLeft();
                } else {
//                    2）
                    head = btNodeStack.pop();
                    System.out.print(head.getValue() + ",");//打印该节点
                    head = head.getRight();//看该节点的右子树，重走1步骤
                }
            }
        }
    }

    public static void postOrderTravelBT(BTNode head) {
        if (head == null) {
            return;
        }
        Stack<BTNode> mstack = new Stack<>();
        Stack<BTNode> mstack2 = new Stack<>();
        mstack.push(head);
        while (!mstack.isEmpty()) {
            BTNode btNode = mstack.pop();
            mstack2.push(btNode);
            if (btNode.getLeft() != null) {
                mstack.push(btNode.getLeft());
            }
            if (btNode.getRight() != null) {
                mstack.push(btNode.getRight());
            }
        }

        while (!mstack2.isEmpty()){
            BTNode pop = mstack2.pop();
            System.out.print(pop.getValue()+",");
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
//        preOrderTravelBT(head);
//        System.out.println();
//        middleOrderTravelBT(head);
        System.out.println();
        postOrderTravelBT(head);
    }
}
