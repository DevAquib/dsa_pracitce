class Solution {
    public int maxDepth(TreeNode root) {

        // If the current node is null, it means we have reached beyond a leaf.
        // Depth of a null node is 0, so return 0.
        if (root == null) return 0;

        // Recursively find the depth of the left subtree.
        // This call will compute the entire height of the subtree rooted at root.left.
        int lh = maxDepth(root.left);

        // Recursively find the depth of the right subtree.
        // This call will compute the entire height of the subtree rooted at root.right.
        int rh = maxDepth(root.right);

        // The depth of the current tree is:
        // 1 (for the current node) + the larger depth between left and right subtrees.
        return 1 + Math.max(lh, rh);
    }
}
