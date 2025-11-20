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
    public List<Integer> inorderTraversal(TreeNode root) {
        // List to store the final inorder traversal result
        List<Integer> ans = new ArrayList<>();

        // Stack to simulate recursion manually
        Stack<TreeNode> st = new Stack<>();

        // Pointer to track the current node
        TreeNode node = root;

        // Continue until we have processed all nodes
        while (true) {

            // Step 1: Keep traversing left subtree and push nodes to stack
            if (node != null) {
                st.push(node);        // Store current node before going left
                node = node.left;     // Move to left child
            } 
            else {
                // Step 2: If node is null, it means left subtree is done
                if (st.isEmpty()) break;   // Stack empty → traversal finished

                // Step 3: Pop from stack (this node’s left subtree is processed)
                node = st.pop();           // Visit this node
                ans.add(node.val);         // Add current node’s value to result

                // Step 4: Move to the right subtree of the popped node
                node = node.right;
            }
        }

        // Step 5: Return the complete inorder traversal
        return ans;
    }
}
