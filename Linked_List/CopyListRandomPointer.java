/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // If the original list is empty, simply return null
        if (head == null) return null;

        // Step 1: Create a HashMap to store mapping:
        // original_node -> cloned_node
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;

        // Step 2: First pass — create all clone nodes (only values, no pointers)
        // and store mapping of original -> clone.
        while (temp != null) {
            Node newNode = new Node(temp.val);   // clone node with the same value
            map.put(temp, newNode);              // map original to cloned
            temp = temp.next;                    // move forward
        }

        // Step 3: Second pass — assign next and random pointers for each cloned node
        temp = head;
        while (temp != null) {
            // Set cloned.next = clone of original.next
            map.get(temp).next = map.get(temp.next);

            // Set cloned.random = clone of original.random
            map.get(temp).random = map.get(temp.random);

            temp = temp.next; // move forward
        }

        // Step 4: Return the cloned head corresponding to original head
        return map.get(head);
    }
}
