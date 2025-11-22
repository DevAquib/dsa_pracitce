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

    public int goodNodes(TreeNode root) {
        // Start DFS with:
        // ans = 0 (unused but kept for structure)
        // curMax = Integer.MIN_VALUE (so root always counts as "good")
        return helper(root, 0, Integer.MIN_VALUE);
    }

    private int helper(TreeNode root, int ans, int curMax) {
        // Base case: empty node contributes 0 good nodes
        if (root == null) return 0;

        int curAns = 0;

        // A node is "good" if its value is >= maximum value seen on the path so far
        if (root.val >= curMax) {
            curAns = 1;       // This node is good
            curMax = root.val; // Update max for the path going downward
        }

        // Recurse left and right with the updated max
        int leftAns = helper(root.left, ans, curMax);
        int rightAns = helper(root.right, ans, curMax);

        // Total good nodes from this subtree
        return curAns + leftAns + rightAns;
    }
}
