package util;

import data.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by baiyuanwei on 17/8/5.
 */
public class TreeUtil {

    /**
     * main 函数
     */
    public static void main() {
        Tree root = createSampleTree();
//        Stack<Tree> stack = findNode(root, 3);
//        while (stack.size() > 0) {
//            System.out.println(stack.pop().getData());
//        }

//        layerTraverseTree(root);

//        Tree q = root.getLeftChild().getRightChild().getRightChild();
//        Tree p = root.getLeftChild().getRightChild().getRightChild().getLeftChild();
//        Tree node = getMinParentNode(root, q, p);
//        System.out.println("最低公共父结点：node = " + node.getData());

//        int depth = getDepth(root, 0);
//        System.out.println("root.depth = " + depth);

        Tree header = changeToLink(getTwoSearchTree());
        while (header.getLeftChild() != null) {
//            System.out.print(" - " + header.getData());
            header = header.getLeftChild();
        }

        while (header != null) {
            System.out.print(" - " + header.getData());
            header = header.getRightChild();
        }

    }

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
        Tree t8 = new Tree(8);
        Tree t9 = new Tree(9);
        Tree t10 = new Tree(10);
        Tree t11 = new Tree(11);


        t1.setLeftChild(t2);
        t1.setRightChild(t3);
        t2.setLeftChild(t4);
        t2.setRightChild(t5);
        t4.setRightChild(t6);
        t5.setLeftChild(t7);
        t5.setRightChild(t8);
        t8.setLeftChild(t9);
        t8.setRightChild(t10);
        t10.setLeftChild(t11);


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

    /**
     * 层序遍历
     *
     * @param header
     */
    public static void layerTraverseTree(Tree header) {
        if (header == null) {
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(header);
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            System.out.println(node.getData());
            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }

    /**
     * 根据前序、中序遍历创建一颗二叉树
     *
     * @param front
     * @param mid
     * @return
     */
    public static Tree createTree(int[] front, int[] mid) {
        if (front == null || front.length <= 0 || mid == null || mid.length <= 0 || mid.length != front.length) {
            return null;
        }
        int len = front.length;

        return createTree(front, mid, 0, len - 1, 0, len - 1);
    }

    /**
     * 根据前序、中序遍历创建一颗二叉树
     *
     * @param front
     * @param mid
     * @param frontStart
     * @param frontEnd
     * @param midStart
     * @param midEnd
     * @return
     */
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

    /**
     * 查找一颗树中的一个节点，并返回其路径
     *
     * @param node
     * @param num
     * @return
     */
    public static Stack<Tree> findNode(Tree node, int num) {
        Stack<Tree> stack = new Stack<>();
        getPath(node, num, stack);
        Stack<Tree> resultStack = new Stack<>();
        while (stack.size() > 0) {
            resultStack.push(stack.pop());
        }

        return resultStack;
    }

    /**
     * 得到一个节点到根节点的路径
     *
     * @param node
     * @param num
     * @param stack
     * @return
     */
    public static boolean getPath(Tree node, int num, Stack<Tree> stack) {
        if (node == null) {
            return false;
        }

        stack.push(node);
        if (node.getData() == num) {
            return true;
        }

        boolean leftResult = getPath(node.getLeftChild(), num, stack);
        boolean rightResult = getPath(node.getRightChild(), num, stack);

        if (!leftResult && !rightResult) {
            stack.pop();
            return false;
        } else {
            return true;
        }
    }

    /**
     * 求两个结点的最低公共父结点
     *
     * @param root
     * @param q
     * @param p
     * @return
     */
    public static Tree getMinParentNode(Tree root, Tree q, Tree p) {
        if (root == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        Tree nodeLeft = getMinParentNode(root.getLeftChild(), q, p);
        Tree nodeRight = getMinParentNode(root.getRightChild(), q, p);
        if (nodeLeft != null && nodeRight != null) {
            return root;
        }
        return nodeLeft == null ? nodeRight : nodeLeft;
    }

    /**
     * 求树的深度
     *
     * @param header
     * @param count
     * @return
     */
    public static int getDepth(Tree header, int count) {
        if (header != null) {
            count++;
        } else {
            return count;
        }

        int leftCount = getDepth(header.getLeftChild(), count);
        int rightCount = getDepth(header.getRightChild(), count);

        return leftCount < rightCount ? rightCount : leftCount;
    }

    /**
     * 得到一个二元查找树
     *
     * @return
     */
    public static Tree getTwoSearchTree() {
        Tree t10 = new Tree(10);
        Tree t6 = new Tree(6);
        Tree t4 = new Tree(4);
        Tree t8 = new Tree(8);
        Tree t14 = new Tree(14);
        Tree t12 = new Tree(12);
        Tree t16 = new Tree(16);

        t10.setLeftChild(t6);
        t10.setRightChild(t14);
        t6.setLeftChild(t4);
        t6.setRightChild(t8);
        t14.setLeftChild(t12);
        t14.setRightChild(t16);

        return t10;
    }

    /**
     * 把二元查找树转变成排序的双向链表
     *
     * @param root
     * @return
     */
    public static Tree changeToLink(Tree root) {
        Stack<Tree> stack = new Stack();
        middleTraverseTree(root, stack);

        Tree current = stack.pop();
        int size = stack.size();
        for (int i = size - 1; i >= 0; i--) {
            Tree t = stack.pop();
            current.setRightChild(t);
            t.setLeftChild(current);
            current = t;
        }

        return current;
    }

    /**
     * 中序遍历 保存在栈中
     *
     * @param root
     * @param stack
     */
    public static void middleTraverseTree(Tree root, Stack<Tree> stack) {
        if (root != null) {
            middleTraverseTree(root.getLeftChild(), stack);
            stack.push(root);
            middleTraverseTree(root.getRightChild(), stack);
        }
    }

}
