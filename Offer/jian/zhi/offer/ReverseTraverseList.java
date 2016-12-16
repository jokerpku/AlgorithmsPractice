package jian.zhi.offer;

import java.util.Stack;

/**
 * Created by Jokeria on 2016/12/14.
 */
public class ReverseTraverseList {


    public void reverseTraverse1(LinkedNode head) {
        if(head == null) {
            return;
        }
        reverseTraverse1(head.next);
        System.out.print(head.val);
    }

    public void reverseTraverse2(LinkedNode head) {

        Stack<Integer> stack = new Stack<Integer>();
        LinkedNode node = head;
        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
