package inteview;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Simple on 2016/12/8.
 */
public class FindCommonParent {
    class TreeNode {
        int val;
        List<TreeNode> children;
        public TreeNode() {}
    }

    public boolean getPath(TreeNode root, TreeNode t, Stack<TreeNode> path) {
        if(root == t) {
            return true;
        } else if(root.children == null){
            return false;
        }
        boolean found = false;
        path.push(root);
        Iterator<TreeNode> iterator = root.children.iterator();
        while(!found && iterator.hasNext()) {
            found = getPath(iterator.next(), t, path);
        }

        if(!found) {
            path.pop();
        }

        return found;
    }

    public TreeNode getCommonNode(Stack<TreeNode> path1, Stack<TreeNode> path2) {
        Iterator<TreeNode> iterator1 = path1.iterator();
        Iterator<TreeNode> iterator2 = path2.iterator();
        TreeNode res = null;
        while(iterator1.hasNext() && !iterator2.hasNext()) {
            TreeNode node1 = iterator1.next();
            TreeNode node2 = iterator2.next();
            if(node1 == node2) {
                res = node1;
            } else {
                return res;
            }
        }

        return res;
    }

    public TreeNode findCommonParent(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }

        Stack<TreeNode> path1 = new Stack<TreeNode>();
        getPath(root, p, path1);
        Stack<TreeNode> path2 = new Stack<TreeNode>();
        getPath(root, q, path2);

        return getCommonNode(path1, path2);
    }

}


