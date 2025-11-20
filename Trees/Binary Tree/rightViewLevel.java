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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        // Edge case: empty tree → no right-side view
        if (root == null) return ans;

        // Standard BFS queue to traverse level-by-level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // BFS traversal
        while (!q.isEmpty()) {

            // Number of nodes in the current level
            int n = q.size();

            // Process all nodes of this level
            for (int i = 0; i < n; i++) {

                TreeNode curr = q.remove();

                /**
                 * Key Insight (right-side view using BFS):
                 * - We traverse the entire level.
                 * - The LAST node we visit at each level (i == n - 1)
                 *   is the rightmost node for that level.
                 * - So we record it.
                 */
                if (i == n - 1) {
                    ans.add(curr.val);
                }

                // Push children for next level
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return ans;
    }
}
