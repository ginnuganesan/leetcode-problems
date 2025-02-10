/* PROBLEM DESCRIPTION

You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.

*/

//Solution

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder out = new StringBuilder();
        while(!stack.isEmpty()){
            out.append(stack.peek());
            stack.pop();
        }
        return out.reverse().toString();
    }
}
