package com.fdh.algorithm.day07;


/**
 * 二叉树的后继节点。
 * 所谓的后继节点：中序遍历的情况下下一个节点
 */
public class Code08_SuccessorNodeBT {


    public static class Node {
        public Node left;
        public Node right;
        public Node parent;//指向父节点
        public Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static Node successorNode(Node node) {
        if (node == null) {
            return null;
        }
        //此节点右树(孩子)不为空,后继就是此节点右树最左节点
        if (node.right != null) {
            return getSubTreeLeftNode(node);
        } else {//右树为空情况
            //1,此节点为某节点左子树开始,直接返回此节点
            //2,此节点为某节点右子树开始,一直向上查询,直到满足上面1
            Node parent = node.parent;
            while (parent != null && parent.left != node) { // 当前节点是其父亲节点右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;


        }
    }

    private static Node getSubTreeLeftNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
