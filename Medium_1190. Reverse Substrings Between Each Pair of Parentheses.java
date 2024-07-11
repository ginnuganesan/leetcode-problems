/* PROBLEM DESCRIPTION

You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 

Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.

*/

//Solution

class Solution {
    public String reverseParentheses(String s) {
        int start, end;
        while(true) {
            end = s.indexOf(')');

            if(end == -1) {
                break;
            }

            start = s.lastIndexOf('(', end);

            s = reverseString(s, start + 1, end - 1);

            s = s.substring(0, start) + s.substring(start + 1, end) + s.substring(end + 1);
        }
        return s;
    }

    public String reverseString(String s, int start, int end) {
        StringBuilder str = new StringBuilder();

        for(int i = end; i >= start; i--) {
            str.append(s.charAt(i));
        }

        return s.substring(0, start) + str.toString() + s.substring(end + 1);
    }
}
