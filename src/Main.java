import data.Node;
import util.Array;
import util.LinkUtil;

public class Main {

    private static Node header = null;
    private static Node current = null;

    private static Node header1 = null;
    private static Node current1 = null;

    private static Node header2 = null;
    private static Node current2 = null;

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 4, 6, 9, 14, 16},
                {2, 5, 7, 12, 15, 19},
                {8, 10, 11, 13, 17, 22},
                {20, 21, 23, 25, 27, 30}};

//        boolean isExist = util.Array.isExist(array, 20);
//        System.out.println("isExist = " + isExist);

//        String result = util.StringUtils.replaceNullSpace(" we are happy . ", "%20");
//        System.out.println("result = " + result);

//        Tree header = util.TreeUtil.createSampleTree();
//        util.TreeUtil.frontTraverseTree(header);
//        System.out.println();
//        util.TreeUtil.middleTraverseTree(header);
//        System.out.println();
//        util.TreeUtil.lastTraverseTree(header);

        /**
         * 指定二叉树的前序遍历和中序遍历，重建二叉树，并输出后序遍历
         */
//        int[] front = new int[]{1, 2, 4, 6, 5, 7, 3};
//        int[] mid = new int[]{4, 6, 2, 7, 5, 1, 3};
//        Tree header = util.TreeUtil.createTree(front, mid);
//        util.TreeUtil.lastTraverseTree(header);

        /**
         * 用两个栈实现队列
         */
//        data.QueueByStack queue = new data.QueueByStack<Integer>();
//        for (int i = 0; i < 8; i++) {
//            queue.put(i);
//        }
//        while (!queue.isEmpty()) {
//            System.out.println(queue.get());
//        }

        /**
         * 给一个整数，求其二进制中1的个数
         */
//        int count = util.NumberUtil.getOneCount(13);
//        System.out.println("count = " + count);

        /**
         * 求一个数的整数次方
         */
//        double result = util.NumberUtil.power(-0.5, -4);
//        System.out.println("result= " + result);

        /**
         * 打印1到最大的n位数
         */
//        util.NumberUtil.printAllNum(5);

        /**
         * 调整数组顺序使奇数位于偶数前面
         */
        int[] num = new int[]{2, 3, 5, 6, 7, 8, 10, 11, 13, 14, 15};
        Array.exchangeNum(num, 0, num.length - 1);
        traverseArray(num);

    }

    /**
     * 遍历数组
     *
     * @param num
     */
    private static void traverseArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

    /**
     * 链表相关的算法
     */
    private static void linked() {
        header = new Node(0);
        current = header;

        for (int i = 1; i < 4; i++) {
            addNode(new Node(i));
        }
        Node loopIn = new Node(90);
        current.setNext(loopIn);
        current = loopIn;

        for (int k = 5; k < 8; k++) {
            addNode(new Node(k));
        }
        //设置环链表
//        current.setNext(loopIn);


        header1 = new Node(0);
        current1 = header1;
        for (int h = 1; h < 4; h++) {
            addNode1(new Node(h));
        }

        header2 = new Node(0);
        current2 = header2;
        for (int v = 1; v < 7; v++) {
            addNode2(new Node(v));
        }

        for (int q = 7; q < 12; q++) {
            Node node = new Node(q);
            addNode2(node);
            addNode1(node);
        }

        /**
         * 遍历链表
         */
//        traverseLinked(header);

        System.out.println("========================================");

        /**
         * 删除节点
         */
//        System.out.println("***********delete**************");
//        Node deleteNode = header.getNext().getNext().getNext().getNext();
//        System.out.println("data = " + deleteNode.getData());
//
//        deleteNode(deleteNode);


        /**
         * 链表倒置
         */
//        Node node = header;
//        Node n = transpositionLink2(node);
////        Node n = transpositionLink(node);
//        traverseLinked(n);

        /**
         * 求链表倒数第k个节点
         */
//        Node node = getKNode(header, 1);
//        System.out.println("data = " + node.getData());

        /**
         * 求链表的中间节点
         */
//        Node midNode = getMidNode(header);
//        System.out.println("data = " + midNode.getData());

        /**
         * 判断链表是否有环
         */
//        boolean isExistLoop = isExistLoop(header);
//        System.out.println("isExistLoop = " + isExistLoop);

        /**
         * 链表中有环，求环的入口节点？
         */
//        Node enterNode = getLoopInNode(header);
//        if (enterNode != null) {
//            System.out.println("data = " + enterNode.getData());
//        } else {
//            System.out.println("node = null");
//        }

        /**
         * 判断两个链表是否相交
         */
//        boolean isCrossed = isCrossed(header1, header);
//        System.out.println("isCrossed = " + isCrossed);


        /**
         * 获取两个相交链表的交点，链表是没有环的
         */
//        Node crossedNode = getCrossedNode(header1, header2);
//        System.out.println("data = " + crossedNode.getData());

        /**
         * 从链表的尾部开始遍历
         */
        LinkUtil.traverseLinked(header);
        System.out.println("##########################");
        LinkUtil.traverseLinkedBack(header);
    }

    /**
     * 添加节点
     *
     * @param node
     */
    private static void addNode(Node node) {
        current.setNext(node);
        current = node;
    }

    private static void addNode1(Node node) {
        current1.setNext(node);
        current1 = node;
    }

    private static void addNode2(Node node) {
        current2.setNext(node);
        current2 = node;
    }
}
