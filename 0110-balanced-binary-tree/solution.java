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
    public boolean isBalanced(TreeNode root) {
        int res = height(root);
        if(res==-1){
            return false;
        }
        return true;
    }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftside = height(root.left);
        if(leftside==-1) return -1;
        int rightside = height(root.right);
        if(rightside==-1) return -1;
        if (Math.abs(leftside-rightside)>1) return -1;
        return Math.max(leftside,rightside) + 1;
    }
}
