/* PROBLEM DESCRIPTION

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        }
        ListNode temp = head;
        int track = 0;
        ListNode subList = new ListNode(-1);
        ListNode itr = subList;
        ListNode preStart = null;
        ListNode rightNext = null;
        while(temp != null) {
            track++;
            if (track >= left && track <= right) {
                itr.next = temp;
                itr = itr.next;
            } else if (track < left) {
                preStart = temp;
            } else if (track == right + 1) {
                rightNext = temp;
            }
            temp = temp.next;
        }
        if(preStart != null) {
            preStart.next = null;
        }
        itr.next = null;
        ListNode rev = reverse(subList.next);
        ListNode revItr = rev;
        ListNode revTail = null;
        while(revItr != null) {
            if(revItr.next == null) {
                revTail = revItr;
            }
            revItr = revItr.next;
        }
        if(preStart != null) {
            preStart.next = rev;
        } else {
            head = rev;
        }
        revTail.next = rightNext;
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode before = null;
        ListNode curr = head;
        ListNode after = null;
        while(curr != null) {
            after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;
        }
        return before;
    }
}
