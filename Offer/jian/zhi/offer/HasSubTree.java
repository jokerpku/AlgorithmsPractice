package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class HasSubTree {
    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        boolean res = false;
        if (root1.val == root2.val) {
            res = isSubTree(root1, root2);
        }
        if (!res) {
            res = hasSubTree(root1.left, root2);
        }
        if (!res) {
            res = hasSubTree(root1.right, root2);
        }

        return res;
    }

    public boolean isSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

//        boolean res = false;
//        res = isSubTree(root1.left, root2.left);
//        if(res) {
//            res = isSubTree(root1.right, root2.right);
//        }

        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }

}
