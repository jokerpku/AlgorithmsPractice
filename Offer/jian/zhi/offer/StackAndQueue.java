package jian.zhi.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jokeria on 2016/12/14.
 */
public class StackAndQueue {


    public static void main(String[] args) {
        QueueByStack<Integer> queue = new QueueByStack<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.isEmpty());
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        queue.add(4);
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        queue.add(5);
        System.out.print(queue.remove() + " ");
        queue.add(6);
        queue.add(7);
        queue.add(8);
        System.out.print(queue.remove() + " ");
        System.out.print(queue.remove() + " ");
        System.out.print(queue.peek() + " ");
        System.out.println(queue.isEmpty());
        System.out.print(queue.remove() + " ");
        System.out.println(queue.isEmpty());

        StackByQueue<Integer> stack = new StackByQueue<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty());
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push(4);
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        stack.push(5);
        System.out.print(stack.pop() + " ");
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.peek() + " ");
        System.out.println(stack.isEmpty());
        System.out.print(stack.pop() + " ");
        System.out.println(stack.isEmpty());
    }
}

/**
 * 用两个队列实现栈
 */
class StackByQueue<T> {
    Queue<T> qin = new LinkedList<T>();
    Queue<T> qout = new LinkedList<T>();
//        Queue<T> qin = null;
//        Queue<T> qout = null;

//        public StackByQueue() {
//            qin = qa;
//            qout = qb;
//        }

    public void push(T ele) {
        qin.add(ele);
    }

    public T pop() {
        // 栈顶元素在qin的尾部，如果qin为empty，则栈顶元素在qout的尾部
        if(this.isEmpty()) {
            return null;
        }
        if(qin.isEmpty()) {
            Queue<T> qtemp = qout;
            qout = qin;
            qin = qtemp;
        }
        T ele = qin.remove();
        while(!qin.isEmpty()) {
            qout.add(ele);
            ele = qin.remove();
        }
        return ele;
    }

    public T peek() {
        T res = pop();
        qout.add(res);
        return res;
    }

    public boolean isEmpty() {
        if(qin.isEmpty() && qout.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


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

    public boolean isEmpty() {
        if(sin.isEmpty() && sout.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
