/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // If one list is empty, the result is the other list
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0;  // carry from previous digit addition

        // Dummy node to build the result list easily
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;  // keep reference of head to return later

        // Traverse until both lists are fully processed AND no carry remains
        while (l1 != null || l2 != null || carry > 0) {

            int sum = 0;

            // Add digit from l1
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add digit from l2
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Add carry from previous step
            if (carry > 0) {
                sum += carry;
                carry = 0;    // reset carry — will be recalculated below
            }

            // If sum > 9, compute new digit and carry
            if (sum > 9) {
                carry = sum / 10;  // typically 1
                sum = sum % 10;    // digit to place in node
            }

            // Create node for the calculated digit
            dummy.next = new ListNode(sum);
            dummy = dummy.next;  // move forward
        }

        // Return the head of constructed list
        return ans.next;
    }
}
