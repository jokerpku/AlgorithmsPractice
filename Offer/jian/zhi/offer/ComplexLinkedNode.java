package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/19.
 */
public class ComplexLinkedNode {
    int val;
    ComplexLinkedNode next = null;
    ComplexLinkedNode sibling = null;

    public ComplexLinkedNode() {
    }

    public ComplexLinkedNode(int val) {
        this.val = val;
    }

    public ComplexLinkedNode clone() {
        if(this == null) {
            return null;
        }
        cloneNodes(this);
        cloneSiblings(this);
        return divideNodes(this);
    }

    private void cloneNodes(ComplexLinkedNode head) {
        ComplexLinkedNode cur = head;
        while(cur != null) {
            ComplexLinkedNode copy = new ComplexLinkedNode(cur.val);
            copy.sibling = cur.sibling;
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
    }

    private void cloneSiblings(ComplexLinkedNode head) {
        ComplexLinkedNode cur = head;
        while(cur != null) {
            ComplexLinkedNode copy = cur.next;
            if(copy.sibling != null) {
                copy.sibling = copy.sibling.next;
            }
            cur = copy.next;
        }
    }

    private ComplexLinkedNode divideNodes(ComplexLinkedNode head) {
        ComplexLinkedNode newHead = head.next;
        ComplexLinkedNode cur = head;
        ComplexLinkedNode newCur = newHead;
        while(cur != null) {
            cur.next = newCur.next;
            cur = cur.next;
            if(cur != null) {
                newCur.next = cur.next;
            } else {
                newCur.next = null;
            }
            newCur = newCur.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ComplexLinkedNode n1 = new ComplexLinkedNode(1);
        ComplexLinkedNode n2 = new ComplexLinkedNode(2);
        ComplexLinkedNode n3 = new ComplexLinkedNode(3);
        ComplexLinkedNode n4 = new ComplexLinkedNode(4);
        ComplexLinkedNode n5 = new ComplexLinkedNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.sibling = n3;
        n2.sibling = n5;
        n4.sibling = n2;

        ComplexLinkedNode n1Clone = n1.clone();
        System.out.println();;

    }
}
