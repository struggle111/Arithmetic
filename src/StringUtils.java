/**
 * Created by baiyuanwei on 17/8/5.
 */
public class StringUtils {

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
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }
}
