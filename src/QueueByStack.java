import java.util.Stack;

/**
 * 两个栈实现一个队列
 * <p>
 * Created by baiyuanwei on 17/8/6.
 */
public class QueueByStack<T> {

    private Stack<T> s1;
    private Stack<T> s2;

    public QueueByStack() {
        this.s1 = new Stack<T>();
        this.s2 = new Stack<T>();
    }

    public void put(T t) {
        if (s1 != null) {
            s1.push(t);
        }
    }

    public T get() {
        if (s2 != null) {
            if (s2.size() <= 0) {
                while (s1.size() > 0) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        return null;
    }

    public int size() {
        if (s1 != null && s2 != null) {
            return s1.size() + s2.size();
        }
        return 0;
    }

    public boolean isEmpty() {
        if ((s1 != null && s1.size() > 0) || (s2 != null && s2.size() > 0)) {
            return false;
        }
        return true;
    }
}
