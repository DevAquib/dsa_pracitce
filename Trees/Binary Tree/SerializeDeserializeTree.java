/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SerializeDeserializeTree {

    // ================================
    // SERIALIZE (Tree → String)
    // ================================
    public String serialize(TreeNode root) {

        // If tree is empty, return empty string
        if (root == null) return "";

        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        // BFS traversal
        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            // Use "n" to represent null nodes
            if (node == null) {
                ans.append("n ");
                continue;
            }

            // Append current node value
            ans.append(node.val).append(" ");

            // Push children even if they are null
            // This preserves tree structure
            q.add(node.left);
            q.add(node.right);
        }

        return ans.toString();
    }

    // ================================
    // DESERIALIZE (String → Tree)
    // ================================
    public TreeNode deserialize(String data) {

        // If empty string, return null tree
        if (data.length() == 0) return null;

        // Split serialized string by spaces
        String[] s = data.split(" ");

        // First value is always the root
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Index starts from 1 because 0 is root
        for (int i = 1; i < s.length; i++) {

            // Parent node for these children
            TreeNode node = q.poll();

            // -------------------------------
            // Process LEFT CHILD
            // -------------------------------
            if (!s[i].equals("n")) {  
                // Create real TreeNode (not null)
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                node.left = left;
                q.add(left);
            } else {
                node.left = null;
            }

            // Move to the next element for right child
            i++;

            // -------------------------------
            // Process RIGHT CHILD
            // -------------------------------
            if (!s[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                node.right = right;
                q.add(right);
            } else {
                node.right = null;
            }
        }

        return root;
    }
}
