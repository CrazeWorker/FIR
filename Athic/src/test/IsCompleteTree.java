package test;

import java.util.*;

public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> strings = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            String value;
            if (tree != null) {
                queue.offer(tree.left);
                queue.offer(tree.right);
                strings.add(tree.val + "");
            } else {
                strings.add("null");
            }
        }
        return !strings.contains("null");
    }
}
