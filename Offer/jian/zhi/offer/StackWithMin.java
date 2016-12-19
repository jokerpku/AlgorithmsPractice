package jian.zhi.offer;

import java.util.Stack;

/**
 * Created by Jokeria on 2016/12/19.
 */
public class StackWithMin {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int num) {
        stack.push(num);
        if(minStack.isEmpty() || num < minStack.peek()) {
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin instance = new StackWithMin();
        instance.push(4);
        int min = instance.getMin();
        instance.push(5);
        min = instance.getMin();
        instance.push(3);
        min = instance.getMin();
        instance.pop();
        min = instance.getMin();
        instance.push(2);
        min = instance.getMin();
        instance.push(6);
        min = instance.getMin();
        instance.push(3);
        min = instance.getMin();
        instance.pop();
        min = instance.getMin();
        instance.pop();
        min = instance.getMin();
        instance.pop();
        min = instance.getMin();
        instance.pop();
        min = instance.getMin();
        instance.pop();
        min = instance.getMin();
        instance.pop();
        min = instance.getMin();
        System.out.println();
    }
}
