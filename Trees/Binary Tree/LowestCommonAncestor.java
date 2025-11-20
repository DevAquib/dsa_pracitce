/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    // LCA in a Binary Tree (NOT BST) using DFS (postorder)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // BASE CASE:
        // If root is null → no node found here.
        // If root matches p or q → return that node upward.
        // This helps identify when we have "found" one of the targets.
        if (root == null || root == p || root == q) return root;

        // RECURSE on both subtrees to find p and q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // CASE 1: Both left and right returned non-null.
        // This means p is in one subtree and q is in the other.
        // → Current root is the LCA.
        // if (left != null && right != null) return root;

        // CASE 2: Only left subtree returned a valid node.
        // Both targets are somewhere in the left subtree.
        if (right == null) return left;

        // CASE 3: Only right subtree returned a valid node.
        // Both targets are somewhere in the right subtree.
        else if (left == null) return right;

        // Technically unreachable, but keeps structure consistent.
        else return null;
    }
}
