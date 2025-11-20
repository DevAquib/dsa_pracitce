class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // Result list to store postorder traversal (Left -> Right -> Root)
        List<Integer> ans = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) return ans;

        // Stack for iterative traversal
        Stack<TreeNode> st = new Stack<>();

        // 'cur' points to the current node, 'lastVis' remembers the last visited node
        TreeNode cur = root, lastVis = null;

        // Continue while there are unvisited nodes or stack is not empty
        while (cur != null || !st.isEmpty()) {

            // 1️⃣ Go as far left as possible
            if (cur != null) {
                st.push(cur);      // Push current node before going left
                cur = cur.left;    // Move to left child
            } 
            else {
                // 2️⃣ Look at the top node without popping
                TreeNode temp = st.peek();

                // 3️⃣ If right child exists and not yet processed, move to right child
                if (temp.right != null && lastVis != temp.right) {
                    cur = temp.right;   // Explore right subtree
                } 
                else {
                    // 4️⃣ Otherwise, both left and right are done — process this node
                    st.pop();           // Remove it from stack
                    ans.add(temp.val);  // Add node value to result
                    lastVis = temp;     // Mark this node as last visited
                }
            }
        }

        // Return the postorder traversal list
        return ans;
    }
}
