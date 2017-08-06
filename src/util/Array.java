package util;

/**
 * Created by baiyuanwei on 17/8/5.
 */
public class Array {


    public static boolean isExist(int[][] array, int num) {

        if (array == null) {
            return false;
        }

        int rows = array.length;
        int columns = array[0].length;

        int row = 0;
        int column = columns - 1;
        while (row >= 0 && row < rows && column >= 0 && column < columns) {
            if (array[row][column] == num) {
                return true;
            } else if (array[row][column] > num) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     *
     * @param array
     * @param low
     * @param high
     */
    public static void exchangeNum(int[] array, int low, int high) {

        if (low >= high) {
            return;
        }
        if (array[low] % 2 == 0 && array[high] % 2 == 1) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            exchangeNum(array, ++low, --high);
        } else if (array[low] % 2 == 0) {
            exchangeNum(array, low, --high);
        } else if (array[high] % 2 == 1) {
            exchangeNum(array, ++low, high);
        } else {
            exchangeNum(array, ++low, --high);
        }
    }
}
