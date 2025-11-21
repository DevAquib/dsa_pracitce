class Solution {
    // Helper function to find the inorder predecessor of the current node.
    // The predecessor is the rightmost node in the left subtree.
    private TreeNode helper(TreeNode root) {
        TreeNode cur = root;

        // Step 1: Go to the left child
        if (root.left != null) root = root.left;

        // Step 2: Find the rightmost node in the left subtree
        // Stop when root.right is null OR root.right is cur (thread already created)
        while (root.right != null && root.right != cur) {
            root = root.right;
        }
        return root;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // Morris Traversal → O(1) space, O(n) time
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeNode cur = root;

        while (root != null) {
            // Case 1: No left child → print value and move right
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                // Case 2: Left child exists → find inorder predecessor
                TreeNode predecessor = helper(root);

                // Case 2a: Create a temporary thread
                if (predecessor.right == null) {
                    // Create a link back to the current node
                    predecessor.right = root;
                    // Move to left subtree
                    root = root.left;
                } else {
                    // Case 2b: Thread already exists → remove it
                    predecessor.right = null;
                    // Visit current node
                    ans.add(root.val);
                    // Move to right subtree
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
