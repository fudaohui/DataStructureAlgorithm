package com.fdh.algorithm.day05;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

/**
 * 基于hashmap实现的前缀树
 */
public class Code02_TrieTreeBaseMap {

    private NodeBaseMap rootNode;

    public class NodeBaseMap {
        //通过该节点次数
        private int pass;
        //在该节点结束的次数
        private int end;
        private HashMap<Integer, NodeBaseMap> nexts;

        public NodeBaseMap() {
            pass = 0;
            end = 0;
            nexts = new HashMap();
        }
    }

    public Code02_TrieTreeBaseMap() {
        rootNode = new NodeBaseMap();
    }

    /**
     * 前缀树插入
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word == "") {
            return;
        }
        char[] chars = word.toCharArray();
        rootNode.pass++;
        NodeBaseMap node = rootNode;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts.get(index) == null) {
                node.nexts.put(index, new NodeBaseMap());
            }
            node = node.nexts.get(index);
            node.pass++;
        }
        //循环结束
        node.end++;
    }
}
