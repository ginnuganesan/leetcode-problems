/* PROBLEM DESCRIPTION

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100

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
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        ListNode kPointerFromL = null;
        ListNode kPointerFromR = null;
        int track = 1;
        while(temp != null) {
            if(track == k) {
                kPointerFromL = temp;
            }
            if(track == n-k+1) {
                kPointerFromR = temp;
            }
            temp = temp.next;
            track++;
        }
        int tempVal = kPointerFromL.val;
        kPointerFromL.val = kPointerFromR.val;
        kPointerFromR.val = tempVal;
        return head;
    }
}
