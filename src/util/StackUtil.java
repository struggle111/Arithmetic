package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by baiyuanwei on 17/8/11.
 */
public class StackUtil {

    /**
     * main 函数
     */
    public static void main() {

        judgeStackSample();

    }

    /**
     * 根据压入栈的序列，判断出栈序列是否正确
     * <p>
     * demo
     */
    public static void judgeStackSample() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);

        List<Integer> output = new ArrayList<>();
        output.add(4);
        output.add(3);
        output.add(5);
        output.add(1);
        output.add(2);

        boolean flag = judgeStack(input, output);
        System.out.println("result = " + flag);
    }


    /**
     * 根据压入栈的序列，判断出栈序列是否正确
     *
     * @param input
     * @param output
     * @return
     */
    public static boolean judgeStack(List<Integer> input, List<Integer> output) {
        Stack<Integer> stack = new Stack<>();

        int length = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) != output.get(length)) {
                stack.push(input.get(i));
            } else if (stack.size() > 0 && stack.peek() == output.get(length)) {
                stack.pop();
                length++;
            } else {
                length++;
            }
        }

        while (length < output.size()) {
            if (output.get(length) != stack.pop()) {
                return false;
            }
            length++;
        }
        return true;
    }
}
