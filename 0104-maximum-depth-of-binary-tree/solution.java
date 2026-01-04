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
    public int maxDepth(TreeNode root) {
        int ans = -1;
        if(root==null){
            return 0;
        }
        int leftHT = maxDepth(root.left);
        int rightHT = maxDepth(root.right);
        ans = Math.max(leftHT,rightHT)+1;

        return ans;
        
    }
}
