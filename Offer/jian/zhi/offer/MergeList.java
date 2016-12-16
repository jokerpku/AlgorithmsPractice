package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class MergeList {
    public LinkedNode merge(LinkedNode head1, LinkedNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }

        LinkedNode head = null;
        if(head1.val > head2.val) {
            head = head2;
            head.next = merge(head1, head2.next);
        } else {
            head = head1;
            head.next = merge(head1.next, head2);
        }

        return head;
    }
}
