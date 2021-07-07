package com.fdh.algorithm.day07;

import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化和反序列化
 * 方法：
 * 1、使用什么方式序列化就使用什么方式反序列化
 * 2、序列化时候不能省去null孩子，后者无法序列化
 * 这里实现后序和层序序列化和反序列化
 * 注：中序遍历不能反序列化
 */
public class Code05_SerializeAndReserializeTree {

    /**
     * 后序遍历：每个子树都是：左子树，右子树，头节点
     *
     * @param header
     * @return
     */
    public static Stack<Integer> postSerializeTree(BTNode header) {
        Stack<Integer> stackNodes = new Stack<>();
        postSerial(stackNodes, header);
        return stackNodes;
    }

    private static void postSerial(Stack<Integer> stack, BTNode header) {
        if (header == null) {//不可忽略空
            stack.add(null);
        } else {
            postSerial(stack, header.getLeft());
            postSerial(stack, header.getRight());
            stack.add(header.getValue());
        }
    }

    /**
     * 反序列化
     *
     * @param stackNodes
     * @return
     */
    private static BTNode postReSerialize(Stack<Integer> stackNodes) {
        if (stackNodes == null || stackNodes.size() <= 0) {
            return null;
        }
        return postReserialBuild(stackNodes);
    }

    public static BTNode postReserialBuild(Stack<Integer> stackNodes) {
        Integer value = stackNodes.pop();
        if (value == null) {
            return null;
        }
        BTNode head = new BTNode(value);
        head.setRight(postReserialBuild(stackNodes));
        head.setLeft(postReserialBuild(stackNodes));
        return head;
    }

    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.setLeft(new BTNode(2));
        head.setRight(new BTNode(3));
        head.getLeft().setLeft(new BTNode(4));
        head.getLeft().setRight(new BTNode(5));
        head.getRight().setLeft(new BTNode(6));
        head.getRight().setRight(new BTNode(7));
        Stack<Integer> stack = postSerializeTree(head);
        for (Integer integer : stack) {
            System.out.print(integer == null ? "null," : integer + ",");
        }

        System.out.println();
        BTNode btNode = postReSerialize(stack);
        Stack<Integer> stack1 = postSerializeTree(btNode);
        for (Integer integer : stack1) {
            System.out.print(integer == null ? "null," : integer + ",");
        }

    }
}
