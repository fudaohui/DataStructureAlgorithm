package com.fdh.algorithm.day05;

/**
 * 前缀树
 * 使用场景：字符串动态匹配，词频统计
 * 设计基础：数据,限制只支持小写字母，第一个节点为空节点
 * 相关思考：
 * https://www.zhihu.com/question/27168319/answer/338588087
 */
public class Code01_TrieTreeBaseArray {
    /**
     * 根节点
     */
    private NodeBaseArray rootNode;

    public class NodeBaseArray {
        //通过该节点次数
        private int pass;
        //在该节点结束的次数
        private int end;
        private NodeBaseArray[] nexts;

        public NodeBaseArray() {
            pass = 0;
            end = 0;
            nexts = new NodeBaseArray[26];//初始26个节点
        }
    }

    public Code01_TrieTreeBaseArray() {
        this.rootNode = new NodeBaseArray();
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
        NodeBaseArray node = rootNode;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new NodeBaseArray();
            }
            node = node.nexts[index];
            node.pass++;
        }
        //循环结束
        node.end++;
    }

    /**
     * 前缀树删除,先查询在删除
     *
     * @param word
     */
    public void delete(String word) {
        if (search(word) != 0) {
            char[] chars = word.toCharArray();
            NodeBaseArray node = rootNode;
            node.pass--;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts[index].pass == 0) {//没必要在向下遍历了
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    /**
     * 前缀树搜索出现的次数，词频统计
     *
     * @param word
     * @return
     */
    public int search(String word) {
        if (word == null || word == "") {
            return 0;
        }
        char[] chars = word.toCharArray();
        NodeBaseArray curNode = rootNode;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (curNode.nexts[index] == null) {

                return 0;
            }
            curNode = curNode.nexts[index];
        }
        return curNode.end;
    }

    /**
     * 统计以word开始的字符串出现的次数
     *
     * @param word
     * @return
     */
    public int prefixStart(String word) {

        if (word == null || word == "") {
            return 0;
        }
        char[] chars = word.toCharArray();
        NodeBaseArray curNode = rootNode;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (curNode.nexts[index] == null) {
                return 0;
            }
            curNode = curNode.nexts[index];
        }
        return curNode.pass;
    }


    public static void main(String[] args) {
        Code01_TrieTreeBaseArray treeBaseArray = new Code01_TrieTreeBaseArray();
        treeBaseArray.insert("abc");
//        treeBaseArray.insert("abe");
//        treeBaseArray.insert("abcd");
//        treeBaseArray.insert("abc");
        treeBaseArray.delete("abc");
//        System.out.println(treeBaseArray.prefixStart("abc"));
        System.out.println(treeBaseArray.search("abc"));
//        System.out.println(treeBaseArray.search("abcd"));
    }
}
