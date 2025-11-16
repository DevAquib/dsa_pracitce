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

    // DFS helper to collect the rightmost node at every level
    private void helper(TreeNode root, int level, List<Integer> ans) {
        // Base case: null node, nothing to process
        if (root == null) return;

        /**
         * Key insight:
         * - 'level' represents the current depth (starting from 0)
         * - 'ans.size()' tells how many levels we've already added
         * 
         * If both are equal → this is the FIRST node we are seeing at this level.
         * Because we go RIGHT first, the first node is automatically the rightmost node.
         */
        if (level == ans.size()) ans.add(root.val);

        // First go to the right subtree (so rightmost nodes get priority)
        helper(root.right, level + 1, ans);

        // Then explore the left subtree
        helper(root.left, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        // Edge case: empty tree → empty right-side view
        if (root == null) return ans;

        // Start DFS from level 0
        helper(root, 0, ans);
        return ans;
    }
}
