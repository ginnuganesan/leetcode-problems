/* PROBLEM DESCRIPTION

Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;

        mid.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeList(leftHead, rightHead);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        ListNode merged = new ListNode(-1);
        ListNode ptr = merged;

        while(leftHead != null && rightHead != null) {
            if(leftHead.val < rightHead.val) {
                ptr.next = leftHead;
                leftHead = leftHead.next;
            } else {
                ptr.next = rightHead;
                rightHead = rightHead.next;
            }
            ptr = ptr.next;
        }

        while(leftHead != null) {
            ptr.next = leftHead;
            leftHead = leftHead.next;
            ptr = ptr.next;
        }

        while(rightHead != null) {
            ptr.next = rightHead;
            rightHead = rightHead.next;
            ptr = ptr.next;
        }

        return merged.next;
    }
}
