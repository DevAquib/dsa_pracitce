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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Start the post-order recursive removal process
        return helper(root, target);
    }

    /**
     * Recursively removes leaf nodes whose value equals 'target'.
     * 
     * Approach:
     * - Use post-order traversal (process children before parent)
     * - After pruning left and right subtrees, check if current node
     *   becomes a leaf AND its value matches target.
     * - If yes → delete this node (return null).
     * - Otherwise return the node unchanged.
     */
    private TreeNode helper(TreeNode root, int target) {

        // Base case: empty subtree
        if (root == null) return null;

        // Recursively process left and right children first (post-order)
        root.left = helper(root.left, target);
        root.right = helper(root.right, target);

        // After pruning children, check if this node is now a target leaf
        if (root.left == null && root.right == null && root.val == target) {
            return null; // Delete this leaf node
        }

        // Return the node (possibly with updated children)
        return root;
    }
}
