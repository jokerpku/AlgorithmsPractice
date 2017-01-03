package jian.zhi.offer;

/**
 * 判断一棵二叉树是否是平衡二叉树
 * 如果某二叉树的任意结点的左右子树深度不超过1，则该二叉树为平衡二叉树
 * 采用后续遍历的方法，保证每个节点只遍历一次
 * Created by Jokeria on 2017/1/3.
 */
public class BalanceTree {
    public boolean isBalancedTree(BinaryTreeNode root) {
        if(root == null) {
            return true;
        }

        int res = getBalanceTreeDepth(root);

        return (res == -1) ? false : true;
    }

    /**
     * 获取平衡二叉树的深度，若不是平衡二叉树，则返回-1
     * @param root
     * @return
     */
    int getBalanceTreeDepth(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getBalanceTreeDepth(root.left);
        if(left != -1) {
            int right = getBalanceTreeDepth(root.right);
            if(right != -1 && Math.abs(left - right) <= 1) {
                return (left > right) ? (left + 1) : (right + 1);
            }
        }

        return -1;
    }

    public int treeDepth(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return (left > right) ? (left + 1) : (right + 1);
    }

    public static void main(String[] args) {
        BalanceTree instance = new BalanceTree();

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
        n8.right = n9;

        boolean res = instance.isBalancedTree(n3);
        System.out.println(res);
    }
}
