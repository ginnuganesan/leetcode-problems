/* PROBLEM DESCRIPTION

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?

*/

//Solution

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode result = new ListNode(-1);
        ListNode out = result;
        while(temp != null) {
            ListNode partition = new ListNode(-1);
            ListNode node = partition;
            int track = 0;
            for(int i = 0; i < k; i++) {
                if(temp != null) {
                    node.next = new ListNode(temp.val);
                    node = node.next;
                    temp = temp.next;
                    track++;
                }
            }
            ListNode rev = null;
            if(track == k) {
                rev = reverse(partition.next);
            } else {
                rev = partition.next;
            }
            while(rev != null) {
                out.next = new ListNode(rev.val);
                out = out.next;
                rev = rev.next;
            }
        }
        return result.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode before = null;
        ListNode temp = head;
        ListNode after = null;
        while(temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }
}
