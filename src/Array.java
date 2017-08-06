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
}
