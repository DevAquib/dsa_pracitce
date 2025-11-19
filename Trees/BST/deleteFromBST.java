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

    // Deletes a node with 'key' from a BST and returns the new root.
    // Core idea: Find the node → delete it correctly depending on number of children.
    public TreeNode deleteNode(TreeNode root, int key) {

        // Base case: Key not found
        if (root == null) return null;

        // If root itself is the node to delete → handle separately
        if (root.val == key) return helper(root);

        // Keep reference to return original root
        TreeNode dummy = root;

        // BST search for the node's parent
        while (root != null) {

            // Move left if key is smaller or equal
            if (root.val >= key) {

                // If left child is the node to delete
                if (root.left != null && root.left.val == key) {
                    // Replace left child with its deletion result
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }

            } else { // Move right if key is larger

                // If right child is the node to delete
                if (root.right != null && root.right.val == key) {
                    // Replace right child with its deletion result
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return dummy;
    }

    // Handles deletion logic once the target node is found
    // Three cases: 0 child, 1 child, 2 children
    private TreeNode helper(TreeNode root) {

        // Case 1: No left child → replace with right subtree
        if (root.left == null) return root.right;

        // Case 2: No right child → replace with left subtree
        else if (root.right == null) return root.left;

        // Case 3: Two children
        else {
            // Save left subtree
            TreeNode leftHead = root.left;

            // Find left-most child in right subtree (inorder successor parent)
            TreeNode lastLeft = lastLeft(root.right);

            // Attach entire left subtree to the found node's left
            lastLeft.left = leftHead;

            // Return right subtree as the new root
            return root.right;
        }
    }

    // Returns the left-most node in a subtree (smallest value)
    // Used to attach the left subtree when deleting a node with 2 children
    private TreeNode lastLeft(TreeNode root) {
        if (root.left == null) return root;
        return lastLeft(root.left);
    }
}
