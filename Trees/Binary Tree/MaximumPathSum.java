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

    // Global variable to store the maximum path sum found so far.
    // Initialized to the smallest value because node values can be negative.
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    /**
     * Returns the maximum "single-branch" path sum from the current node
     * going upward to its parent.
     *
     * At every node we compute:
     * 1. Maximum gain from left subtree (ignore if negative — treat as 0).
     * 2. Maximum gain from right subtree (ignore if negative — treat as 0).
     * 3. Best full path through this node = leftGain + node.val + rightGain.
     *    Update global max with this value.
     *
     * Then return to parent: node.val + max(leftGain, rightGain)
     * Because a parent can only take one side — otherwise the path forks.
     */
    private int helper(TreeNode root) {
        // Base case: null contributes 0
        if (root == null) return 0;

        // Recursively compute max gains from left/right children.
        // If the gain is negative, we drop it (take 0 instead).
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        // Full path sum using both sides + current node.
        int fullPath = root.val + left + right;

        // Update the global max path sum with this node-centered path.
        maxSum = Math.max(maxSum, fullPath);

        // Return the best single path upward:
        // node value + whichever side gives the higher gain.
        return root.val + Math.max(left, right);
    }
}
