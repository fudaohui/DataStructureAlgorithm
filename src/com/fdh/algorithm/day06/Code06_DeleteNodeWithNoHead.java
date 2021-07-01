package com.fdh.algorithm.day06;

/**
 * 不给单链表的头节点，只给想要删除的节点，就能做到在链表上把这个点删掉？
 * 处理思路：将此node的next节点的数据复制到此节点，然后将此node节点next指针指向原node的next的next
 * 注意：此方法的局限性：无发删除尾部节点（无法修改上一个节点的next指针）；能否顺利复制下一个节点数据问题
 */
public class Code06_DeleteNodeWithNoHead {
}
