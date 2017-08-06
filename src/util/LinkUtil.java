package util;

import data.Node;

import java.util.Stack;

/**
 * Created by baiyuanwei on 17/8/6.
 */
public class LinkUtil {
    /**
     * 遍历链表
     * 从头到尾
     */
    public static void traverseLinked(Node header) {
        Node temp = header;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    /**
     * 遍历链表
     * 从尾到头
     *
     * @param header
     */
    public static void traverseLinkedBack(Node header) {
        Stack<Integer> stack = new Stack<>();
        Node temp = header;
        while (temp != null) {
            stack.push(temp.getData());
            temp = temp.getNext();
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


    /**
     * 删除节点
     * 只知道要删除的节点的指针，要求时间复杂度为O(1)
     *
     * @param node
     */
    public static void deleteNode(Node node) {
        Node temp = node.getNext();
        if (temp != null) {
            node.setData(temp.getData());
            node.setNext(temp.getNext());
            temp.setNext(null);
            temp = null;
        } else {
            node.setData(0);
            node.setNext(null);
            node = null;
        }
    }

    /**
     * 单链表的转置
     * 方法：循环遍历
     */
    public static Node transpositionLink(Node header) {

        if (header == null || header.getNext() == null) {
            return header;
        }
        Node next = null;
        Node pre = null;

        while (header != null) {
            next = header.getNext();
            header.setNext(pre);
            pre = header;
            header = next;
        }
        return pre;
    }

    /**
     * 单链表的转置
     * 方法：递归
     *
     * @param header
     * @return
     */
    public static Node transpositionLink2(Node header) {

        //异常判断
        if (header == null) {
            return header;
        }

        if (header.getNext() == null) {
            return header;
        }

        Node newHeader = transpositionLink2(header.getNext());
        header.getNext().setNext(header);
        header.setNext(null);

        return newHeader;
    }

    /**
     * 求链表倒数第k个节点
     * 思路：定义两个指针p1、p2都指向头节点，p2指针移动（k-1）个节点后，p1指针开始移动，当p2移动到尾指针的时候，p1就是所求；
     *
     * @param header
     * @param k
     * @return
     */
    public static Node getKNode(Node header, int k) {
        Node p1 = header;
        Node p2 = header;

        for (int i = 1; i < k; i++) {
            if (p2.getNext() == null) {
                return null;
            }
            p2 = p2.getNext();

        }

        while (p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p1;
    }

    /**
     * 求链表的中间节点
     * 思路1：可以先遍历一次链表，算出链表的长度，然后计算出中间点，然后通过求倒数第k个节点的方法计算出中间节点，这样遍历了链表两遍；
     * 思路2: 定义两个指针p1、p2指向头指针，p1移动一步，p2移动两步，这样p2移动到尾指针时，p1就是所求；
     */
    public static Node getMidNode(Node header) {
        Node p1 = header;
        Node p2 = header;

        while (p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (p2 == null) {
                return p1;
            }
        }

        return p1;

    }

    /**
     * 判断链表是否有环
     */
    public static boolean isExistLoop(Node header) {
        if (header == null) {
            return false;
        }
        Node p1 = header;
        Node p2 = header;
        while (header.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (p1 == p2) {
                return true;
            }

            if (p2 == null) {
                return false;
            }
            header = p2;
        }

        return false;
    }

    /**
     * 判断链表是否有环
     */
    public static Node isExistLoop2(Node header) {
        if (header == null) {
            return null;
        }
        Node p1 = header;
        Node p2 = header;
        while (header.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if (p2 == null) {
                return null;
            }

            if (p1 == p2) {
                return p1;
            }
            header = p2;
        }

        return null;
    }

    /**
     * 如果链表有环，求环的入口
     *
     * @param header
     * @return
     */
    public static Node getLoopInNode(Node header) {

        Node h = header;
        Node temp = isExistLoop2(h);
        if (temp != null) {
            Node p1 = temp;
            Node p2 = header;
            while (p2 != null) {
                p1 = p1.getNext();
                p2 = p2.getNext();
                if (p1 == p2) {
                    return p1;
                }
            }
        }
        return null;
    }

    /**
     * 获取链表长度
     *
     * @param header
     * @return
     */
    public static int getLinkedSum(Node header) {

        int count = 0;
        while (header != null) {
            count = count + 1;
            header = header.getNext();
        }

        return count;
    }


    /**
     * 判断两个链表是否相交，链表中没有环
     */
    public static boolean isCrossed(Node header1, Node header2) {
        Node p1 = header1;
        while (p1.getNext() != null) {
            p1 = p1.getNext();
        }

        Node p2 = header2;
        while (p2.getNext() != null) {
            p2 = p2.getNext();
        }

        return p1 == p2;
    }

    /**
     * 判断两个链表是否相交，无论有环无环
     *
     * @param header1
     * @param header2
     * @return
     */
    public static boolean isCrossedAny(Node header1, Node header2) {

        Node p1 = getLoopInNode(header1);
        Node p2 = getLoopInNode(header2);

        if (p1 == null && p2 == null) {
            return isCrossed(header1, header2);
        } else if (p1 == null || p2 == null) {
            return false;
        } else return p1 == p2;
    }

    /**
     * 获取两个相交链表的交点，链表是没有环的
     *
     * @param header1
     * @param header2
     * @return
     */
    public static Node getCrossedNode(Node header1, Node header2) {
        System.out.println("\nheader1:");
        traverseLinked(header1);
        System.out.println("\nheader2:");
        traverseLinked(header2);

        int count1 = getLinkedSum(header1);
        System.out.println("count1 = " + count1);

        int count2 = getLinkedSum(header2);
        System.out.println("count2 = " + count2);

        Node p1 = header1;
        Node p2 = header2;
        if (count1 > count2) {
            for (int i = 0; i < count1 - count2; i++) {
                p1 = p1.getNext();
            }
        } else {
            for (int i = 0; i < count2 - count1; i++) {
                p2 = p2.getNext();
            }
        }

        while (p1 != null && p1 != p2) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return p1;

    }

    /**
     * 合并两个排好序的链表
     */
    public static Node mergeLink(Node h1, Node h2) {

        if (h1 == null && h1 == null) {
            return null;
        } else if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        } else {
            Node header = new Node();
            Node temp = header;

            while (h1 != null && h2 != null) {
                if (h1.getData() < h2.getData()) {
                    temp.setNext(h1);
                    temp = h1;
                    h1 = h1.getNext();


                } else {
                    temp.setNext(h2);
                    temp = h2;
                    h2 = h2.getNext();
                }
            }

            while (h1 != null) {
                temp.setNext(h1);
                temp = h1;
                h1 = h1.getNext();
            }
            while (h2 != null) {
                temp.setNext(h2);
                temp = h2;
                h2 = h2.getNext();
            }

            return header.getNext();
        }

    }

}
