package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class DeleteNode {

    public LinkedNode deleteNode(LinkedNode head, LinkedNode toDel) {
        if(toDel.next == null) { // 删除的是尾结点
            if(toDel == head) { // 既是尾结点也是头结点，说明链表只有一个结点
                return null;
            } else { // 链表中有多个结点没删除尾结点，遍历链表
                LinkedNode node = head;
                while(node.next != toDel) {
                    node = node.next;
                }
                node.next = null;
            }
        } else { // 链表中有多个结点，删除中间结点，将toDel下一节点的内容复制到toDel中
            LinkedNode temp = toDel.next;
            toDel.next = temp.next;
            toDel.val = temp.val;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedNode n1 = new LinkedNode(1);
        DeleteNode instance = new DeleteNode();
        LinkedNode res = instance.deleteNode(n1, n1);
        System.out.println();
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
        res = instance.deleteNode(n2, n7);
        System.out.println();
        res = instance.deleteNode(n2, n5);
        System.out.println();
    }
}
