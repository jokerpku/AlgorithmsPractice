package jian.zhi.offer;

/**
 * 找出两个链表的第一个公共节点
 * Created by Simple on 2017/1/1.
 */
public class FindFirstCommonNode {
    public LinkedNode findFirstCommonNode(LinkedNode node1, LinkedNode node2) {
        if(node1 == null || node2 == null) {
            return null;
        }

        int length1 = getLength(node1);
        int length2 = getLength(node2);

        LinkedNode point1 = node1;
        LinkedNode point2 = node2;
        if(length1 > length2) {
            for(int i = 0; i < length1 - length2; i++) {
                point1 = point1.next;
            }
        } else {
            for(int i = 0; i < length2 - length1; i++) {
                point2 = point2.next;
            }
        }

        while(point1 != null && point2 != null) {
            if(point1 == point2) {
                return point1;
            }

            point1 = point1.next;
            point2 = point2.next;
        }

        return null;
    }

    int getLength(LinkedNode root) {
        LinkedNode node = root;
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    public static void main(String[] args) {
        FindFirstCommonNode instance = new FindFirstCommonNode();
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
        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n3;

        n3.next = n9;
        n9.next = n10;
        n10.next = n11;
        LinkedNode res = instance.findFirstCommonNode(n1, n9);
        System.out.println(res.val);
    }

}
