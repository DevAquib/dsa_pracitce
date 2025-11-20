class Solution {

    // Global variable to store the maximum diameter found so far
    int dia = 0;

    // Function to return the height of the subtree rooted at 'root'
    // While computing height, we also update the diameter
    private int height(TreeNode root) {

        // Base case: empty node has height 0
        if (root == null) return 0;

        // Recursively get height of left subtree
        int lh = height(root.left);

        // Recursively get height of right subtree
        int rh = height(root.right);

        // Diameter at this node = left height + right height
        // Update global diameter if this is the longest path so far
        dia = Math.max(dia, lh + rh);

        // Height of current node = 1 + max(left height, right height)
        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        // Edge case: empty tree has diameter 0
        if (root == null) return 0;

        // Compute height of the tree (this will also compute 'dia')
        height(root);

        // Return the maximum diameter found
        return dia;
    }
}
