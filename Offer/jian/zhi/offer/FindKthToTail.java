package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class FindKthToTail {
    public LinkedNode findKthToTail(LinkedNode head, int k) {
        if(head == null || k == 0) {
            return null;
        }


        LinkedNode p = head;
        // p先往前走k-1步，若期间走到链表末尾，则说明链表长度小于k，返回null
        for(int i = 0; i < k-1; i++) {
            if(p.next != null) {
                p = p.next;
            } else {
                return null;
            }
        }

        LinkedNode pre = head; // p往前k-1个结点
        while(p.next != null) {
            p = p.next;
            pre = pre.next;
        }

        return pre;
    }
}
