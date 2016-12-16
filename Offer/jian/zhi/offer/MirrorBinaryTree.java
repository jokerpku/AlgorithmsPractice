package jian.zhi.offer;

import java.util.Stack;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class MirrorBinaryTree {
    public BinaryTreeNode mirror(BinaryTreeNode root) {
        if(root == null) {
            return null;
        }
        BinaryTreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);

        return root;
    }

    public BinaryTreeNode mirror2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            BinaryTreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        MirrorBinaryTree instance = new MirrorBinaryTree();
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
//        instance.mirror(null);
//        instance.mirror(n9);
//        instance.mirror(n3);
//        instance.mirror(n1);

        instance.mirror2(null);
        instance.mirror2(n9);
        instance.mirror2(n3);
        instance.mirror2(n1);
        System.out.println();

    }
}
