/* PROBLEM DESCRIPTION

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempL1 = reverse(l1);
        ListNode tempL2 = reverse(l2);
        int carry = 0;
        ListNode out = new ListNode(-1);
        ListNode ptr = out;
        while(tempL1 != null || tempL2 != null) {
            int sum = 0;
            if(tempL1 != null) {
                sum += tempL1.val;
                tempL1 = tempL1.next;
            }
            if(tempL2 != null) {
                sum += tempL2.val;
                tempL2 = tempL2.next;
            }
            sum += carry;
            if(sum > 9) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            ptr.next = new ListNode(sum);
            ptr = ptr.next; 
        }
        if(carry > 0) {
            ptr.next = new ListNode(carry);
        }
        return reverse(out.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode after = null;
        ListNode current = head;
        while(current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }
}
