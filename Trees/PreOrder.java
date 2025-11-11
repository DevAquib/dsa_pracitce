class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // List to store the preorder traversal result
        List<Integer> ans = new ArrayList<>();
        
        // Stack to simulate recursion manually
        Stack<TreeNode> st = new Stack<>();
        
        // If the tree is empty, return an empty list
        if (root == null) return ans;
        
        // Start by pushing the root node into the stack
        st.push(root);
        
        // Loop runs until all nodes are processed
        while (!st.isEmpty()) {
            // Take the top node from the stack
            TreeNode a = st.peek();
            
            // Add its value to the result list (preorder → root first)
            ans.add(a.val);
            
            // Pop the current node since it's now processed
            st.pop();
            
            // Push the right child first so that the left child
            // is processed before it (stack is LIFO)
            if (a.right != null) st.push(a.right);
            
            // Push the left child next
            if (a.left != null) st.push(a.left);
        }
        
        // Return the final preorder traversal list
        return ans;
    }
}
