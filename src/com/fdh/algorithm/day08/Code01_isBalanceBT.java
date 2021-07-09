package com.fdh.algorithm.day08;

import com.fdh.algorithm.day07.BTNode;
import com.fdh.algorithm.day07.Code06_PrintBT;

/**
 * 平衡二叉树判断
 * 思路为：分别求左右子树的平衡性，递归到叶子节点
 * 注：左右子树平衡，自己不一定平衡需要通过高度计算
 */
public class Code01_isBalanceBT {


    /**
     * 子树的信息：平衡性，高度（相对于子树的头节点）
     */
    static class BTSubtreeInfo {

        private boolean isBalance;
        private int height;//当前节点左右子树最大深度

        public BTSubtreeInfo(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }

        public boolean isBalance() {
            return isBalance;
        }

        public void setBalance(boolean balance) {
            isBalance = balance;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static boolean isBalanceBT(BTNode head) {

        BTSubtreeInfo btSubtreeInfo = process(head);
        return btSubtreeInfo.isBalance;
    }

    private static BTSubtreeInfo process(BTNode curNode) {

        if (curNode == null) {//子树为null，认为平衡
            return new BTSubtreeInfo(true, 0);
        }
        BTSubtreeInfo leftBtSubtreeInfo = process(curNode.getLeft());//当前节点左子树平衡性
        BTSubtreeInfo rightBTSubtreeInfo = process(curNode.getRight());//当前节点右子树平衡性
        //计算当前节点最为头节点的平衡性
        //当前节点所属子树的最大高度，加上自己
        int curHeight = Math.max(leftBtSubtreeInfo.getHeight(), rightBTSubtreeInfo.getHeight()) + 1;
        //判断当期节点所属子树的平衡性
        boolean isBalance = true;
        if (!leftBtSubtreeInfo.isBalance
                || !rightBTSubtreeInfo.isBalance
                || Math.abs(leftBtSubtreeInfo.height - rightBTSubtreeInfo.height) > 1) {

            // TODO: 2021/7/8 0008 如何发现子树已经不平衡了没必要递归了，如何退出递归？
            isBalance = false;
        }
        return new BTSubtreeInfo(isBalance, curHeight);

    }


    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getRight().setLeft(new BTNode(6));
        head.getRight().setRight(new BTNode(7));
        System.out.println(isBalanceBT(head));
        head.getRight().getRight().setRight(new BTNode(8));
        head.getRight().getRight().getRight().setRight(new BTNode(9));
        Code06_PrintBT.printBT(head);
        System.out.println(isBalanceBT(head));


    }
}
