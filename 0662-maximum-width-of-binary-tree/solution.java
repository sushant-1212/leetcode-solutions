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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Long> index = new LinkedList<>();

        q.offer(root);
        index.offer(0L);

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            long first = index.peek();
            long last = first;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                long curr = index.poll();

                last = curr;

                if (node.left != null) {
                    q.offer(node.left);
                    index.offer(2 * curr + 1);
                }

                if (node.right != null) {
                    q.offer(node.right);
                    index.offer(2 * curr + 2);
                }
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }

        return ans;
    }
}
