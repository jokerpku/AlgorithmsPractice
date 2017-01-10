package inteview;

import jian.zhi.offer.LinkedNode;

/**
 * 求单链表的长度，链表可能有环
 * Created by Jokeria on 2017/1/5.
 */
public class LinkListLength {
    public int getListLength(LinkedNode head) {
        if(head == null) {
            return 0;
        }

        LinkedNode tail = getListTail(head);

        LinkedNode p = head;
        int len = 0;
        while(p != tail) {
            len++;
            p = p.next;
        }

        // 若链表有环，则tail必不为null
        if(tail != null) {
            len++;
        }

        return len;
    }

    /**
     * 找出链表的尾部，若没有环，则返回应该为null，若有环则返回环的最后一个结点
     * @param head
     * @return
     */
    LinkedNode getListTail(LinkedNode head) {

        // 第一次遍历，一个指针走两步，一个指针走一步。找出相遇点
        LinkedNode fast = head;
        LinkedNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }

        }

        // 没有环
        if(fast == null || fast.next == null) {
            return null;
        }

        // slow指向相遇点。
        // 第二次遍历，slow指向相遇点，fast从头开始，每次都走一步，相遇的位置即为环的入口
        // tail指向入口前的结点
        fast = head;
        LinkedNode tail = null;
        while(fast != slow) {
            tail = slow;
            fast = fast.next;
            slow = slow.next;
        }

        return tail;
    }

    public static void main(String[] args) {
        LinkListLength instance = new LinkListLength();
        LinkedNode n0 = new LinkedNode(0);
        LinkedNode n1 = new LinkedNode(1);
        LinkedNode n2 = new LinkedNode(2);
        LinkedNode n3 = new LinkedNode(3);
        LinkedNode n4 = new LinkedNode(4);
        LinkedNode n5 = new LinkedNode(5);
        LinkedNode n6 = new LinkedNode(6);
        LinkedNode n7 = new LinkedNode(7);
        LinkedNode n8 = new LinkedNode(8);
        LinkedNode n9 = new LinkedNode(9);
        LinkedNode n10 = new LinkedNode(10);
        LinkedNode n11 = new LinkedNode(11);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n5;

        LinkedNode tail = instance.getListTail(n3);
        int len = instance.getListLength(n3);
        System.out.println("tail: " + tail.val + " len: " + len);

    }
}
