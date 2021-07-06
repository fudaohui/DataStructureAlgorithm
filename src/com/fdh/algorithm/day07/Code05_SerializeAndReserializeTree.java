package com.fdh.algorithm.day07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 * 方法：
 * 1、使用什么方式序列化就使用什么方式反序列化
 * 2、序列化时候不能省去null孩子，后者无法序列化
 * 这里实现中序和层序序列化和反序列化
 */
public class Code05_SerializeAndReserializeTree {

    /**
     * 中序遍历：每个子树都是：左子树，头节点，右子树
     *
     * @param header
     * @return
     */
    public static Queue<Integer> middleSerializeTree(BTNode header) {
        Queue<Integer> queue = new LinkedList<>();
        middleSe(queue, header);
        return queue;
    }

    private static void middleSe(Queue<Integer> queue, BTNode header) {
        if (header == null) {//不可忽略空
            queue.add(null);
        } else {
            middleSe(queue, header.getLeft());
            queue.add(header.getValue());
            middleSe(queue, header.getRight());
        }
    }

    /**
     * 反序列化
     *
     * @param queue
     * @return
     */
    private BTNode reMiddleSerialize(Queue<Integer> queue) {
        if (queue == null || queue.size() <= 0) {
            return null;
        }

        return reMid(queue);
    }

    public BTNode reMid(Queue<Integer> queue) {
        Integer nodeV = queue.poll();
        BTNode header = new BTNode(nodeV);
        header.setLeft(reMid(queue));
        header.setRight(reMid(queue));
        return header;
    }
}
