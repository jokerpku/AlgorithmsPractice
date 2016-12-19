package jian.zhi.offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jokeria on 2016/12/19.
 */
public class FindPath {
    public void findPath(BinaryTreeNode root, int target) {
        if(root == null) {
            return;
        }

        Stack<BinaryTreeNode> path = new Stack<BinaryTreeNode>();
        findPath(root, target, path);
    }

    void findPath(BinaryTreeNode root, int target, Stack<BinaryTreeNode> path) {

        path.push(root);

        if(root.left == null && root.right == null) {
            if(target == root.val) {
                printStack(path);
            }
        } else {
            if(root.left != null) {
                findPath(root.left, target - root.val, path);
            }
            if(root.right != null) {
                findPath(root.right, target - root.val, path);
            }
        }

        path.pop();
    }

    void printStack(Stack<BinaryTreeNode> path) {
        if(!path.isEmpty()) {
            Iterator<BinaryTreeNode> iterator = path.iterator();
            while(iterator.hasNext()) {
                System.out.print(iterator.next().val + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        FindPath instance = new FindPath();

        BinaryTreeNode n1 = new BinaryTreeNode(10);
        BinaryTreeNode n2 = new BinaryTreeNode(5);
        BinaryTreeNode n3 = new BinaryTreeNode(12);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
//        BinaryTreeNode n6 = new BinaryTreeNode(6);
//        BinaryTreeNode n7 = new BinaryTreeNode(7);
//        BinaryTreeNode n8 = new BinaryTreeNode(8);
//        BinaryTreeNode n9 = new BinaryTreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
//        n3.left = n6;
//        n3.right = n7;
//        n5.left = n8;
//        n6.right = n9;
        instance.findPath(n1, 20);
    }

}
