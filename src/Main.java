public class Main {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 4, 6, 9, 14, 16},
                {2, 5, 7, 12, 15, 19},
                {8, 10, 11, 13, 17, 22},
                {20, 21, 23, 25, 27, 30}};

//        boolean isExist = Array.isExist(array, 20);
//        System.out.println("isExist = " + isExist);

//        String result = StringUtils.replaceNullSpace(" we are happy . ", "%20");
//        System.out.println("result = " + result);

//        Tree header = TreeUtil.createSampleTree();
//        TreeUtil.frontTraverseTree(header);
//        System.out.println();
//        TreeUtil.middleTraverseTree(header);
//        System.out.println();
//        TreeUtil.lastTraverseTree(header);

        /**
         * 指定二叉树的前序遍历和中序遍历，重建二叉树，并输出后序遍历
         */
//        int[] front = new int[]{1, 2, 4, 6, 5, 7, 3};
//        int[] mid = new int[]{4, 6, 2, 7, 5, 1, 3};
//        Tree header = TreeUtil.createTree(front, mid);
//        TreeUtil.lastTraverseTree(header);

        /**
         * 用两个栈实现队列
         */
//        QueueByStack queue = new QueueByStack<Integer>();
//        for (int i = 0; i < 8; i++) {
//            queue.put(i);
//        }
//        while (!queue.isEmpty()) {
//            System.out.println(queue.get());
//        }

        /**
         * 给一个整数，求其二进制中1的个数
         */
//        int count = NumberUtil.getOneCount(13);
//        System.out.println("count = " + count);

        /**
         * 求一个数的整数次方
         */
//        double result = NumberUtil.power(-0.5, -4);
//        System.out.println("result= " + result);

        /**
         * 打印1到最大的n位数
         */
        NumberUtil.printAllNum(5);
    }
}
