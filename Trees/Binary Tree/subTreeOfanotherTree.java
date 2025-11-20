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

    // Helper function to check if two binary trees are exactly identical
    private boolean sameTree(TreeNode p, TreeNode q){
        
        // If both nodes are null → trees match completely
        if(p == null && q == null) return true;

        // If one is null and the other is not → mismatch
        if((p == null && q != null) || (p != null && q == null)) return false;

        // If values don't match → mismatch
        if(p.val != q.val) return false;

        // Recursively check left and right subtrees
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    // Main function to check if subRoot is a subtree of root
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If subRoot is null → empty tree is always a subtree
        if(subRoot == null) return true;

        // If root is null but subRoot is not → impossible to match
        if(root == null) return false;

        // If the subtree starting at this root matches subRoot → return true
        if(sameTree(root, subRoot)) return true;

        // Otherwise, check in the left or right subtree of the current root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
