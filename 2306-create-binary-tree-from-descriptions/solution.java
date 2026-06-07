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
    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        HashSet<Integer> childNodes = new HashSet<>();

        for (int i = 0; i < descriptions.length; i++) {

            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            if (!nodeMap.containsKey(parent)) {
                nodeMap.put(parent, new TreeNode(parent));
            }

            if (!nodeMap.containsKey(child)) {
                nodeMap.put(child, new TreeNode(child));
            }

            TreeNode parentNode = nodeMap.get(parent);
            TreeNode childNode = nodeMap.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            childNodes.add(child);
        }

        for (int i = 0; i < descriptions.length; i++) {

            int parent = descriptions[i][0];

            if (!childNodes.contains(parent)) {
                return nodeMap.get(parent);
            }
        }

        return null;
    }
}
