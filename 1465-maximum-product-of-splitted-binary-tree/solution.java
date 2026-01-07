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

    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        totalSum = findTotalSum(root);   // STEP 1
        findSubtreeSum(root);            // STEP 2
        return (int)(maxProduct % MOD);
    }

    // poore tree ka sum
    long findTotalSum(TreeNode node) {
        if (node == null) return 0;

        long left = findTotalSum(node.left);
        long right = findTotalSum(node.right);

        return node.val + left + right;
    }

    // har subtree ka sum + product calculate
    long findSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = findSubtreeSum(node.left);
        long right = findSubtreeSum(node.right);

        long currSum = node.val + left + right;

        long product = currSum * (totalSum - currSum);
        maxProduct = Math.max(maxProduct, product);

        return currSum;
    }
}

