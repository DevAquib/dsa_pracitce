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
    public List<Integer> postorderTraversal(TreeNode root) {
        // List to store the final postorder traversal result
        List<Integer> ans = new ArrayList<>();

        // Base case: if the tree is empty, return an empty list
        if (root == null) return ans;

        // Two stacks:
        // st1 → used for traversal
        // st2 → used to store nodes in reverse postorder
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        // Start traversal with the root node
        st1.push(root);

        // Step 1: Process nodes in a modified preorder (Root → Right → Left)
        while (!st1.isEmpty()) {
            // Pop from st1 and push it into st2
            TreeNode node = st1.pop();
            st2.push(node);

            // Push left and right children into st1
            // (We push left first so that right is processed before left)
            TreeNode node2 = st2.peek();
            if (node2.left != null) st1.push(node2.left);
            if (node2.right != null) st1.push(node2.right);
        }

        // Step 2: Pop all nodes from st2 → this gives Left → Right → Root (Postorder)
        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }

        // Return the final postorder traversal list
        return ans;
    }
}
