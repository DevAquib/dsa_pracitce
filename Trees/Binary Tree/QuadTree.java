/*
// Definition for a QuadTree node.
class Node {
    public boolean val;            // true = region is 1, false = region is 0
    public boolean isLeaf;         // true = this node represents a uniform region
    public Node topLeft;           // 4 children
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    // Default constructor — unused but provided
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    // Constructor for leaf or internal node (children set later)
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    // Constructor used when all children are known
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    // Entry point: start recursion from full grid (0,0) of size n
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    // Recursively construct QuadTree for subgrid starting at (x, y) of size "size"
    Node helper(int[][] grid, int x, int y, int size) {

        // STEP 1: If the entire subgrid has the same value → make a leaf node
        if (allSame(grid, x, y, size)) {

            // Leaf node → val = (0 or 1 of this region), isLeaf = true
            return new Node(grid[x][y] == 1 ? true : false, true);
        }

        // STEP 2: Otherwise, this region is mixed → internal node
        // val can be anything for internal nodes (LeetCode doesn't use it)
        Node node = new Node(true, false);

        int half = size / 2;

        // Divide the current square into 4 equal sub-squares:
        node.topLeft = helper(grid, x, y, half);
        node.topRight = helper(grid, x, y + half, half);
        node.bottomLeft = helper(grid, x + half, y, half);
        node.bottomRight = helper(grid, x + half, y + half, half);

        return node;
    }

    // Check if all values inside the subgrid (x,y) of width "size" are identical
    boolean allSame(int[][] grid, int x, int y, int size) {

        // Compare every cell with the first cell (grid[x][y])
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {

                // If any cell is different, the region is mixed → not a leaf
                if (grid[i][j] != grid[x][y])
                    return false;
            }
        }

        // If we never found a mismatch → entire region is uniform
        return true;
    }
}
