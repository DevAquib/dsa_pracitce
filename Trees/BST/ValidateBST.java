class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start recursion with the full integer range
        //for every node we are providing a range that its value could lie in
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int minVal, int maxVal) {
        // Base case: An empty tree/subtree is always valid
        if (root == null) return true;

        // Check if current node violates BST property
        // Each node must be strictly between minVal and maxVal
        if (root.val <= minVal || root.val >= maxVal) return false;

        // Recursively check:
        // 1. Left subtree → values must be < root.val
        // 2. Right subtree → values must be > root.val
        return helper(root.left, minVal, root.val)
            && helper(root.right, root.val, maxVal);
    }
}
