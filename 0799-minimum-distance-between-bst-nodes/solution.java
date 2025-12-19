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
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        if(root.left!=null){
            int leftans = minDiffInBST(root.left);
            ans = Math.min(ans,leftans); 
        }
        if(prev!=null){
            ans = Math.min(ans,root.val-prev.val);
        }
        prev = root;
        if(root.right!=null){
            int rightans = minDiffInBST(root.right);
             ans = Math.min(ans,rightans);
        }
        return ans;
    }
}
