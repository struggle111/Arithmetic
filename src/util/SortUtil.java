package util;

/**
 * Created by baiyuanwei on 17/8/30.
 */
public class SortUtil {

    /**
     * main 函数
     */
    public static void main() {
        int[] numArray = new int[]{43, 2, 4, 7, 3, 8, 9, 1, 0, 32, 5, 4, 2};
//        quickSort(numArray, 0, numArray.length - 1);
//        bubbleSort(numArray);
//        bubbleGoodSort(numArray);
//        selectSort(numArray);
//        insertSort(numArray);
//        mergeSort(numArray, 0, numArray.length - 1);
        shellSort(numArray);


        traversalSort(numArray);
    }

    /**
     * 遍历数组
     *
     * @param numArray
     */
    private static void traversalSort(int[] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            System.out.println(numArray[i]);
        }
    }

    /**
     * 快速排序
     *
     * @param array
     * @param low
     * @param high
     */
    private static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int flag = low;
        int index = low + 1;
        while (index <= high) {
            if (array[index] < array[flag]) {
                int num = array[index];
                int temp = index;
                while (temp > flag) {
                    array[temp] = array[temp - 1];
                    temp--;
                }
                array[flag] = num;
                flag++;
            }

            index++;
        }

        quickSort(array, low, flag - 1);
        quickSort(array, flag + 1, high);
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length - i - 1; k++) {
                if (array[k] > array[k + 1]) {
                    int temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化后的冒泡排序
     * <p>
     * <p>
     * 优化点：
     * 1、在一次遍历中，如果没有交换，就代表已经排好序了；
     * 2、记录最后一次交换的位置
     * <p>
     *
     * @param array
     */
    private static void bubbleGoodSort(int[] array) {
        int last = array.length;
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            int current = last;
            for (int k = 1; k < current; k++) {
                if (array[k] < array[k - 1]) {
                    int temp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = temp;
                    flag = true;
                    last = k;
                }
            }

            if (!flag) {
                break;
            }
        }
    }


    /**
     * 选择排序
     *
     * @param num
     */
    private static void selectSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int k = i + 1; k < num.length; k++) {
                if (num[i] > num[k]) {
                    int temp = num[i];
                    num[i] = num[k];
                    num[k] = temp;
                }
            }
        }
    }

//
//    private static void insertSort(int[] array) {
//        if (array == null || array.length == 0) {
//            return;
//        }
//        int index = 0;
//        while (index + 1 < array.length) {
//            if (array[index + 1] < array[index]) {
//                int flag = index - 1;
//                while (flag >= 0) {
//                    if (array[index + 1] >= array[flag]) {
//                        int temp = index + 1;
//                        int num = array[index + 1];
//                        while (temp - 1 > flag) {
//                            array[temp] = array[temp - 1];
//                            temp--;
//                        }
//                        array[temp] = num;
//                        break;
//                    }
//                    flag--;
//                }
//            }
//            index++;
//        }
//    }

    /**
     * 插入排序
     *
     * @param array
     */
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = i;
            while (k > 0 && array[k] < array[k - 1]) {
                int temp = array[k];
                array[k] = array[k - 1];
                array[k - 1] = temp;
                k--;
            }
        }
    }

    /**
     * 归并排序
     *
     * @param array
     * @param low
     * @param high
     */
    private static void mergeSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

        int[] tempArray = new int[array.length];

        int index = low;
        int l2 = mid + 1;
        int flag = low;
        while (low <= mid && l2 <= high) {
            if (array[low] < array[l2]) {
                tempArray[index] = array[low];
                low++;
                index++;
            } else {
                tempArray[index] = array[l2];
                l2++;
                index++;
            }
        }

        while (low <= mid) {
            tempArray[index] = array[low];
            low++;
            index++;
        }

        while (l2 <= high) {
            tempArray[index] = array[l2];
            l2++;
            index++;
        }

        while (flag <= high) {
            array[flag] = tempArray[flag];
            flag++;
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    private static void shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int d = array.length / 2;
        while (d > 0) {
            for (int i = 0; i < array.length; i += d) {
                int k = i;
                while (k >= 0 && k + d < array.length && array[k + d] < array[k]) {
                    int temp = array[k + d];
                    array[k + d] = array[k];
                    array[k] = temp;
                    k -= d;
                }
            }
            d /= 2;
        }
    }

}
