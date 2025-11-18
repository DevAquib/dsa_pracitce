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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If the tree is empty, the new value becomes the root.
        if (root == null) return new TreeNode(val);

        // Use an iterator pointer (cur) to traverse without modifying the actual root.
        TreeNode cur = root;

        // BST insertion is always done at a leaf position.
        while (true) {

            // If the new value is greater than or equal to current node → go to the right subtree
            if (cur.val <= val) {

                // If right child exists, continue traversing
                if (cur.right != null) {
                    cur = cur.right;
                } 
                // If right child does NOT exist, this is the correct insertion point
                else {
                    cur.right = new TreeNode(val);
                    break;  // insertion done
                }
            }

            // If the new value is smaller than current node → go to the left subtree
            else {

                // If left child exists, continue traversing
                if (cur.left != null) {
                    cur = cur.left;
                } 
                // If left child does NOT exist, insert here
                else {
                    cur.left = new TreeNode(val);
                    break;  // insertion done
                }
            }
        }

        // Return the original root, since insertion happens in-place.
        return root;
    }
}
