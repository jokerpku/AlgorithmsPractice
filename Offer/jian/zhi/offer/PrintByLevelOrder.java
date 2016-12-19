package jian.zhi.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jokeria on 2016/12/19.
 */
public class PrintByLevelOrder {
    public void printByLevelOrder(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.print(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n6.right = n9;

        PrintByLevelOrder instance = new PrintByLevelOrder();
        instance.printByLevelOrder(n1);
    }
}
