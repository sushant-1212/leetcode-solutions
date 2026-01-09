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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int leftHT = height(root.left);
        int rightHt = height(root.right);
        if(leftHT>rightHt){
            return subtreeWithAllDeepest(root.left);
        } else if(leftHT<rightHt){
            return subtreeWithAllDeepest(root.right);
        } else{
            return root;
        }
        
    }
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHT = height(root.left);
        int rightHt = height(root.right);
        return Math.max(leftHT,rightHt)+1;
    }

}
