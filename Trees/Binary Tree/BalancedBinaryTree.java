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

    // This function returns the height of the subtree rooted at 'root'
    // BUT it uses the value -1 as a signal that the subtree is NOT balanced.
    private int height(TreeNode root) {

        // Base case: empty tree has height 0
        if (root == null) return 0;

        // Recursively get height of left subtree
        int lh = height(root.left);

        // If left subtree is unbalanced, bubble up -1 immediately
        if (lh == -1) return -1;

        // Recursively get height of right subtree
        int rh = height(root.right);

        // If right subtree is unbalanced, bubble up -1 immediately
        if (rh == -1) return -1;

        // If current node is unbalanced (difference > 1), return -1
        if (Math.abs(lh - rh) > 1) return -1;

        // Otherwise, return height of current node
        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {

        // An empty tree is always balanced
        if (root == null) return true;

        // If height() returns -1, tree is unbalanced; otherwise balanced
        return height(root) != -1;
    }
}
