package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/14.
 */
public class RebuildTree {

    /**
     * 输入保证前序数组和中序数组正确
     * @param preorder
     * @param midorder
     * @return
     */
    public BinaryTreeNode rebuildTree(int[] preorder, int[] midorder) {
        if(preorder == null || midorder == null) {
            return null;
        }

        int len = preorder.length;
        return rebuildTree(preorder, midorder, 0, 0, len);
    }

    public BinaryTreeNode rebuildTree(int[] preorder, int[] midorder, int prelo, int midlo, int len) {
        if(len == 0) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(preorder[prelo]);
        int index = findInMidorder(preorder[prelo], midorder, midlo, len);
        int leftLen = index - midlo;
        root.left = rebuildTree(preorder, midorder, prelo + 1, midlo, leftLen);
        root.right = rebuildTree(preorder, midorder, prelo + 1 + leftLen, index + 1, len - 1 - leftLen);
        return root;
    }

    public int findInMidorder(int val, int[] midorder, int midlo, int len) {
        int index = midlo;
        while(index < midlo + len) {
            if(midorder[index] == val) {
                return index;
            } else {
                index++;
            }
        }
        if(index == midlo + len) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] midorder = {4,7,2,1,5,3,8,6};

        RebuildTree instance = new RebuildTree();
        BinaryTreeNode root = instance.rebuildTree(preorder, midorder);
        System.out.println();;

    }
}
