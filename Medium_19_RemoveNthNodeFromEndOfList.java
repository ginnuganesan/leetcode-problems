/* PROBLEM DESCRIPTION

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode ptr = head;
        int length = 0;
        while(temp != null) {
            temp = temp.next;
            length++;
        }
        int track = 0;
        ListNode prev = null;
        while(ptr != null) {
            track++;
            if(track == length-n+1) {
                if(ptr == head) {
                    head = head.next;
                } else {
                    prev.next = ptr.next;
                }
            } else {
                prev = ptr;
            }
            ptr = ptr.next;
        }
        return head;
    }
}
