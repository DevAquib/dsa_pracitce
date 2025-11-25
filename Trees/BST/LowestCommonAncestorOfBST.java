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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case:
        // If root is null OR root matches p OR root matches q,
        // then root is the LCA for this subtree.
        if(root == null || root == p || root == q) return root;

        // BST property:
        // If both p and q values are smaller than root,
        // LCA must be in the left subtree.
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        // If both p and q values are greater than root,
        // LCA must be in the right subtree.
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        // If the above two conditions fail,
        // it means p and q lie on different sides.
        // This is the split point → root is the LCA.
        return root;
    }
}
