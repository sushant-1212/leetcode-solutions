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
    List<Integer> ans = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
    public TreeNode buildBst(int l , int h){
        if(l>h){
            return null;
        }
        int mid = l+(h-l)/2;
        TreeNode root = new TreeNode(ans.get(mid));
        root.left = buildBst(l,mid-1);
        root.right = buildBst(mid+1,h);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        
        inorder(root);
        return buildBst(0,ans.size()-1);
    }
}
