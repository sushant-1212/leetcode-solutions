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
    int num = 0;
    int sum = 0;
    void recursion(TreeNode root){
        if(root==null){
            return;
        }
        num = num*10 + root.val;
        if(root.left==null && root.right==null){
            sum+=num;
        }
        recursion(root.left);
        recursion(root.right);
        num = num/10;
    }

    public int sumNumbers(TreeNode root) {
        recursion(root);
        return sum;
        
    }
}
