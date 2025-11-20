// Kth Smallest Element in a BST (Recursive Inorder Traversal)
// Fully commented for quick revision during SDE 1 interviews

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // We use an array of size 1 so that the counter can be mutated inside recursion.
        // Java passes primitives by value, so we can't use an int directly.
        int[] counter = new int[1];
        counter[0] = 0;

        return helper(root, k, counter);
    }

    private int helper(TreeNode root, int k, int[] counter) {
        // Base case: empty subtree cannot contain the kth smallest
        if (root == null) return -1;

        // -----------------------------
        // 1. Traverse LEFT subtree first (Inorder: L → Node → R)
        // -----------------------------
        int left = helper(root.left, k, counter);

        // If left subtree already found the kth smallest, return immediately.
        // Any non -1 value means answer found.
        if (left != -1) return left;

        // -----------------------------
        // 2. Visit CURRENT node
        // -----------------------------
        counter[0]++;  // Count this node as visited in inorder sequence

        // If this is the kth visited node, this is the kth smallest value
        if (counter[0] == k) return root.val;

        // -----------------------------
        // 3. Traverse RIGHT subtree
        // -----------------------------
        // Whatever the right subtree returns (either answer or -1) is returned upward.
        return helper(root.right, k, counter);
    }
}
