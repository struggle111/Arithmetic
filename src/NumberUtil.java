import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by baiyuanwei on 17/8/6.
 */
public class NumberUtil {

    /**
     * 给一个整数，求其二进制中1的个数
     *
     * @param num
     * @return
     */
    public static int getOneCount(int num) {

        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num / 2;
        }
        return count;
    }

    /**
     * 求一个数的整数次方
     */
    public static double power(double data, int p) {
        if (data == 0) {
            System.out.println("0的任何次幂是没有意义的");
            return 0;
        }
        if (p == 0) {
            return 1;
        } else if (p > 0) {
            return powerFix(data, p);
        } else {
            return 1 / powerFix(data, -p);
        }
    }

    /**
     * @param data
     * @param p    p>0
     * @return
     */
    private static double powerFix(double data, int p) {
        double result = 1.0;
        while (p > 0) {
            result = result * data;
            p--;
        }
        return result;
    }

    /**
     * 打印1到最大的n位数
     */
    public static void printAllNum(int n) {
        int temp = 1;
        while (n - 1 > 0) {
            temp = temp * 10;
            n--;
        }

        int dd = temp;
        while (dd / 10 > 0) {
            temp = temp + dd / 10;
            dd = dd / 10;
        }

        for (int i = 1; i <= temp * 9; i++) {
            System.out.println(i);
        }
    }

}
