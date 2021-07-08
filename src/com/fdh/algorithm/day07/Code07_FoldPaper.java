package com.fdh.algorithm.day07;

/**
 * 折纸问题：
 * <p>
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。
 * 如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。 请从上到下打印所有折痕的方向。
 * 例如:N=1时，打印: down N=2时，打印: down down up
 * <p>
 * 折纸过程：注意上下别折反，标注每一折叠折成凹凸，折叠结果如下：
 * <p>
 * //1次折叠打印：1-凹
 * //2次折叠打印：2-凹，1-凹，2-凸
 * //3次折叠打印：3-凹，2-凹，3-凸，1-凹，3-凹，2-凸，3-凸
 * <p>
 * 可以看出，这是（满）二叉树的中序遍历思想，每一个非叶子节点左孩子均为凹折痕，右孩子均为凸折痕
 * 这里可以不需要根据树深度构建满二叉树
 */
public class Code07_FoldPaper {


    /**
     * n ,折叠的次数
     *
     * @param n
     */
    public static void printPaperFolding(int n) {

        processPrint(1, false, n);
    }

    /**
     * @param i 当前节点所处的深度(层数)
     * @param b 当前节点是否是凸节点
     * @param n 折叠次数也就是满二叉树的最大深度
     */
    public static void processPrint(int i, boolean b, int n) {
        if (i > n) {
            return;
        }
        processPrint(i + 1, false, n);//遍历左子树
        System.out.print(i + "-" + (b == false ? "凹" : "凸") + ",");
        processPrint(i + 1, true, n);//遍历左子树
    }


    public static void main(String[] args) {
        printPaperFolding(3);
    }
}
