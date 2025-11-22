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

    // Global pointer to track current index in preorder array
    // Preorder = [root, left subtree, right subtree]
    int index = 0;

    // Utility function to find a value in inorder[] array
    // This tells us where to split inorder[] into left and right subtree
    private int findPos(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) return i;
        }
        return -1; // should never happen if valid input
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        // Start recursive construction using full inorder range
        return helper(preorder, inorder, 0, n - 1, n);
    }

    /**
     * Recursive function to build tree using preorder + inorder arrays.
     *
     * preorder[index] gives the current root node.
     * stIndex and endIndex define the current segment of the inorder array
     * that represents the current subtree.
     */
    private TreeNode helper(int[] preorder, int[] inorder,
                            int stIndex, int endIndex, int n) {

        // Base case: no elements left
        if (index >= n || stIndex > endIndex) return null;

        // Step 1: Create root using the current preorder element
        TreeNode root = new TreeNode(preorder[index++]);

        // Step 2: Find root position in inorder array to split subtrees
        int pos = findPos(inorder, root.val);

        // Step 3: Recursively build left subtree
        // Left subtree is inorder[stIndex ... pos-1]
        root.left = helper(preorder, inorder, stIndex, pos - 1, n);

        // Step 4: Recursively build right subtree
        // Right subtree is inorder[pos+1 ... endIndex]
        root.right = helper(preorder, inorder, pos + 1, endIndex, n);

        return root;
    }
}
