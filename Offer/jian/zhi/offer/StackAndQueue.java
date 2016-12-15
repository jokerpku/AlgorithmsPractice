package jian.zhi.offer;

import java.util.Stack;

/**
 * Created by Jokeria on 2016/12/14.
 */
public class StackAndQueue {
    /**
     * 用两个队列实现栈
     */
    class StackByQueue {

    }

    /**
     * 用两个栈实现队列
     */
    class QueueByStack<T> {
        Stack<T> sin = new Stack<T>();
        Stack<T> sout = new Stack<T>();

        public void add(T ele) {
            sin.push(ele);
        }

        public T remove() {
            if(!sout.isEmpty()) {
                return sout.pop();
            } else if(!sin.isEmpty()) {
                while(!sin.isEmpty()) {
                    sout.push(sin.pop());
                }
                return sout.pop();
            }
            return null;
        }

        public T peek() {
            if(!sout.isEmpty()) {
                return sout.peek();
            } else if(!sin.isEmpty()) {
                while(!sin.isEmpty()) {
                    sout.push(sin.pop());
                }
                return sout.peek();
            }
            return null;
        }
    }
}
