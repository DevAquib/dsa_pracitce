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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: One node is null and the other is not → trees differ
        if ((p == null && q != null) || (p != null && q == null)) return false;

        // Case 2: Both nodes are null → identical at this branch
        if (p == null && q == null) return true;

        // Case 3: Both exist but values don't match → trees differ
        if (p.val != q.val) return false;

        // Recursively check left children
        boolean left = isSameTree(p.left, q.left);
        if (!left) return false;    // If left subtree mismatches, no need to check further

        // Recursively check right children
        boolean right = isSameTree(p.right, q.right);
        if (!right) return false;   // Same logic as above

        // Both left and right subtrees match → trees are identical
        return true;
    }
}

