/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    int dx = -1, dy = -1;
    TreeNode px = null, py = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        find(root, null, 0, x);
        find(root, null, 0, y);

        return dx == dy && px != py;
    }

    void find(TreeNode root, TreeNode parent, int depth, int val) {
        if (root == null) return;

        if (root.val == val) {
            if (dx == -1) {
                dx = depth;
                px = parent;
            } else {
                dy = depth;
                py = parent;
            }
            return;
        }

        find(root.left, root, depth + 1, val);
        find(root.right, root, depth + 1, val);
    }
}
