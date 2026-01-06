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
    public boolean recursion(TreeNode root , long start , long end){
        if(root==null){
            return true;
        }
        if(root.val<start || root.val>end){
            return false;
        }
        boolean leftPart = recursion(root.left,start,(long)root.val-1l);
        boolean rightPart = recursion(root.right,(long)root.val+1l , end);
        return(leftPart && rightPart);
    }
    public boolean isValidBST(TreeNode root) {
        return(recursion(root,Integer.MIN_VALUE , Integer.MAX_VALUE));
    }
}
