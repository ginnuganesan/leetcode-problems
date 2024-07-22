/* PROBLEM DESCRIPTION

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = temp;
        while(temp != null) {
            ListNode next = temp.next;
            System.out.println(next);
            if(next != null) {
                temp.next = next.next;
                next.next = temp;
            } else {
                prev.next = temp;
            }
            if(temp == head) {
                head = next;
            } else {
                if(next != null) {
                    prev.next = next;
                }
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
