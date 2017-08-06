import data.Tree;

/**
 * Created by baiyuanwei on 17/8/5.
 */
public class TreeUtil {

    /**
     * 一个简单的二叉树
     *
     * @return
     */
    public static Tree createSampleTree() {

        Tree t1 = new Tree(1);
        Tree t2 = new Tree(2);
        Tree t3 = new Tree(3);
        Tree t4 = new Tree(4);
        Tree t5 = new Tree(5);
        Tree t6 = new Tree(6);
        Tree t7 = new Tree(7);

        t1.setLeftChild(t2);
        t1.setRightChild(t3);
        t2.setLeftChild(t4);
        t2.setRightChild(t5);
        t4.setRightChild(t6);
        t5.setLeftChild(t7);


        return t1;
    }

    /**
     * 前序遍历
     *
     * @param header
     */
    public static void frontTraverseTree(Tree header) {
        if (header != null) {
            System.out.print(header.getData() + " ");
            frontTraverseTree(header.getLeftChild());
            frontTraverseTree(header.getRightChild());
        }
    }

    /**
     * 中序遍历
     *
     * @param header
     */
    public static void middleTraverseTree(Tree header) {
        if (header != null) {
            middleTraverseTree(header.getLeftChild());
            System.out.print(header.getData() + " ");
            middleTraverseTree(header.getRightChild());
        }
    }

    /**
     * 后序遍历
     *
     * @param header
     */
    public static void lastTraverseTree(Tree header) {
        if (header != null) {
            lastTraverseTree(header.getLeftChild());
            lastTraverseTree(header.getRightChild());
            System.out.print(header.getData() + " ");
        }
    }

    public static Tree createTree(int[] front, int[] mid) {
        if (front == null || front.length <= 0 || mid == null || mid.length <= 0 || mid.length != front.length) {
            return null;
        }
        int len = front.length;

        return createTree(front, mid, 0, len - 1, 0, len - 1);
    }

    public static Tree createTree(int[] front, int[] mid, int frontStart, int frontEnd, int midStart, int midEnd) {
        Tree header = new Tree(front[frontStart]);
        if (frontStart == frontEnd) {
            if (midStart == midEnd && front[frontStart] == mid[midStart]) {
                return header;
            } else {
                System.out.println("Wrong input !!!!!!");
                return null;
            }
        }

        int i = midStart;
        for (; i <= midEnd; i++) {
            if (mid[i] == front[frontStart]) {
                break;
            }
        }

        if (i == midEnd && mid[i] != front[frontStart]) {
            System.out.println("Wrong input !!!!");
            return null;
        }

        int leftLen = i - midStart;
        if (leftLen > 0) {
            header.setLeftChild(createTree(front, mid, frontStart + 1, frontStart + leftLen, midStart, i - 1));
        }

        if (midEnd - i > 0) {
            header.setRightChild(createTree(front, mid, frontStart + leftLen + 1, frontEnd, i + 1, midEnd));
        }

        return header;
    }
}
