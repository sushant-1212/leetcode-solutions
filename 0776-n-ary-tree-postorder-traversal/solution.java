/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        for (int i = 0; i < root.children.size(); i++) {
            ans.addAll(postorder(root.children.get(i)));
        }

        ans.add(root.val);

        return ans;
    }
}
