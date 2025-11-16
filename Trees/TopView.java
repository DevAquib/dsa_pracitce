/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

// Pair class stores:
// 1. The current node
// 2. Its horizontal distance (HD) from root
class Pair {
    Node first;   // the node
    int second;   // its horizontal distance

    Pair(Node first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Queue for BFS (level-order traversal)
        // Each element: (node, horizontal distance)
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        // TreeMap stores (HD → node value)
        // TreeMap keeps keys sorted → final top view comes in left-to-right order
        Map<Integer, Integer> map = new TreeMap<>();

        // BFS traversal
        while (!q.isEmpty()) {

            Pair p = q.remove();

            int line = p.second;  // horizontal distance (HD)
            Node a = p.first;     // current node

            // For top view:
            // Add a node to map only if that HD is seen for the FIRST time.
            // First node encountered at each HD (from top) is part of top view.
            if (!map.containsKey(line)) {
                map.put(line, a.data);
            }

            // Move to left child → HD decreases by 1
            if (a.left != null) {
                q.add(new Pair(a.left, line - 1));
            }

            // Move to right child → HD increases by 1
            if (a.right != null) {
                q.add(new Pair(a.right, line + 1));
            }
        }

        // Extract the values in sorted HD order (TreeMap ensures this)
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            ans.add(it.getValue());
        }

        return ans;
    }
}
