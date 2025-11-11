class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Final answer list that will store nodes level by level
        List<List<Integer>> ans = new ArrayList<>();

        // Base case: if tree is empty, return empty list
        if (root == null) return ans;

        // Queue is used for BFS (level-order traversal)
        Queue<TreeNode> q = new LinkedList<>();

        // Start BFS by adding the root node to the queue
        q.add(root);

        // Loop until there are no more nodes left to process
        while (!q.isEmpty()) {
            // Number of nodes present at the current level
            int n = q.size();

            // Temporary list to store all node values at this level
            List<Integer> temp = new ArrayList<>();

            // Process all nodes of the current level
            for (int i = 0; i < n; i++) {
                // Get the front node of the queue (but don't remove yet)
                TreeNode node = q.peek();

                // Add the current node's value to this level's list
                temp.add(node.val);

                // If the current node has a left child, add it to the queue
                if (node.left != null) q.add(node.left);

                // If the current node has a right child, add it to the queue
                if (node.right != null) q.add(node.right);

                // Now remove the processed node from the queue
                q.remove();
            }

            // After processing the current level, add it to the final answer
            ans.add(temp);
        }

        // Return the complete level order traversal
        return ans;
    }
}
