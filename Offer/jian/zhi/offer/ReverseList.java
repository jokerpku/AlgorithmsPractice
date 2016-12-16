package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class ReverseList {
    public LinkedNode reverseList(LinkedNode head) {
//        if(head == null) {
//            return null;
//        }

        LinkedNode cur = null;
        LinkedNode post = head;
        while(post != null) {
            LinkedNode temp = post.next;
            post.next = cur;
            cur = post;
            post = temp;
        }

        return cur;
    }

    public static void main(String[] args) {

        ReverseList instance = new ReverseList();

        LinkedNode n1 = new LinkedNode(1);
        LinkedNode n2 = new LinkedNode(2);
        LinkedNode n3 = new LinkedNode(3);
        LinkedNode n4 = new LinkedNode(4);
        LinkedNode n5 = new LinkedNode(5);
        LinkedNode n6 = new LinkedNode(6);
        LinkedNode n7 = new LinkedNode(7);
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        LinkedNode res = instance.reverseList(null);
        res = instance.reverseList(n1);
        res = instance.reverseList(n2);
        System.out.println();
    }
}
