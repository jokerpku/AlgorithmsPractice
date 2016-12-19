package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/19.
 */
public class ConvertDoubleLinkedNode {

    public BinaryTreeNode convert(BinaryTreeNode root) {
        if(root == null) {
            return null;
        }
        return convert(root, null);
    }

    BinaryTreeNode convert(BinaryTreeNode root, BinaryTreeNode last) {
        if(root.left == null && root.right == null) {
            root.left = last;
            if(last != null) {
                last.right = root;
            }
            return root;
        }

        BinaryTreeNode newLast = null;
        // 处理左子树
        if(root.left != null) {
            newLast = convert(root.left, last);
        }

        // 处理根节点
        root.left = newLast;
        if(newLast != null) {
            newLast.right = root;
        }
        newLast = root;

        // 处理右子树
        if(root.right != null) {
            newLast = convert(root.right, newLast);
        }

        return newLast;
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(4);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(6);
        BinaryTreeNode n4 = new BinaryTreeNode(1);
        BinaryTreeNode n5 = new BinaryTreeNode(3);
        BinaryTreeNode n6 = new BinaryTreeNode(5);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        ConvertDoubleLinkedNode instance = new ConvertDoubleLinkedNode();
        BinaryTreeNode res = instance.convert(n1);
        System.out.println();
    }

}
