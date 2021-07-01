package com.fdh.algorithm.day07;

/**
 * 二叉树节点
 */
public class BTNode {

    private Integer value;
    private BTNode left;//左子数节点
    private BTNode right;//右子数节点

    public BTNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }
}
