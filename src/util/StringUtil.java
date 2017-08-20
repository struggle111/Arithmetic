package util;

/**
 * Created by baiyuanwei on 17/8/5.
 */
public class StringUtil {

    /**
     * main 函数
     */
    public static void main() {
        String max = Integer.MIN_VALUE + "";
        System.out.println(max);

        try {

//            String numStr = "-";
//            int num = strToInt(numStr);

            int num = Integer.parseInt("-2147483649");

            System.out.println("num = " + num);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    /**
     * 替换空格
     *
     * @param str
     * @param msg
     * @return
     */
    public static String replaceNullSpace(String str, String msg) {

        if (isEmpty(str)) {
            return str;
        }
        StringBuilder builder = new StringBuilder();

        char[] strChar = str.toCharArray();

        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == ' ') {
                builder.append(msg);
            } else {
                builder.append(strChar[i]);
            }
        }

        return builder.toString();
    }


    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    /**
     * 把字符串转换成整数
     *
     * @param numStr
     * @return
     */
    public static int strToInt(String numStr) throws Exception {

        if (isEmpty(numStr)) {
            throw new Exception("numStr is null");
        }
        byte[] array = numStr.getBytes();
        float div = Integer.MAX_VALUE / 10f;
        int sign = 1;
        int count = 0;
        int min = 0;
        if (array[0] == '+') {
            min = 1;
            sign = 1;
        } else if (array[0] == '-') {
            min = 1;
            sign = -1;
            div = 0 - Integer.MIN_VALUE / 10f;
        }

        int l = array.length - 1;
        int flag = 1;
        while (l > min) {
            flag *= 10;
            l--;
        }

        int index = min;
        while (index < array.length) {
            if (array[index] < '0' || array[index] > '9') {
                throw new Exception("numStr is Illegal!!!");
            }

            count += (array[index] - '0') * flag;
            if (count / 10f > div) {
                throw new Exception("numStr is over!!!");
            }
            index++;
            flag /= 10;
        }
        return count * sign;
    }
}
