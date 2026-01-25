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
    int ans = Integer.MIN_VALUE;
    public int recursion(TreeNode root){
        if(root==null){
            return 0;
        }
        int ops1 = recursion(root.left);
        int ops2 = recursion(root.right);
        int pathsum = (root.val + ops1 + ops2);
        ans = Math.max(ans,pathsum);
        ans = Math.max(ans,root.val);
        ans = Math.max(ans,root.val+(Math.max(ops1,ops2)));
        int res = Math.max(root.val,root.val+Math.max(ops1,ops2));
        return res;
    }
    public int maxPathSum(TreeNode root) {
        int y = recursion(root);
        return ans;
        
    }
}
