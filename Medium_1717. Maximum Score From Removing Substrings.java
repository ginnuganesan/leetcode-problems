/* PROBLEM DESCRIPTION

You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.

*/

//Solution - Brute Force

class Solution {
    public int maximumGain(String s, int x, int y) {
        int gain = 0;
        while(s.indexOf("ba") != -1 || s.indexOf("ab") != -1) {
            if(x > y) {
                if(s.indexOf("ab") != -1) {
                    s = s.replaceFirst("ab", "");
                    gain += x;
                } else {
                    s = s.replaceFirst("ba", "");
                    gain += y;
                }
            } else {
                if(s.indexOf("ba") != -1) {
                    s = s.replaceFirst("ba", "");
                    gain += y;
                } else {
                    s = s.replaceFirst("ab", "");
                    gain += x;
                }
            }
        }
        return gain;
    }
}

//Solution - Optimal

class Solution {
    public int maximumGain(String s, int x, int y) {
        int gain = 0;
        if(x < y) {
            return maximumGain(new StringBuilder(s).reverse().toString(), y, x);
        }

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch != 'b') {
                stack1.push(ch);
            } else {
                if(!stack1.isEmpty() && stack1.peek() == 'a') {
                    stack1.pop();
                    gain += x;
                } else {
                    stack1.push(ch);
                }
            }
        }

        while(!stack1.isEmpty()) {
            char ch = stack1.pop();
            if(ch != 'b') {
                stack2.push(ch);
            } else {
                if(!stack2.isEmpty() && stack2.peek() == 'a') {
                    stack2.pop();
                    gain += y;
                } else {
                    stack2.push(ch);
                }
            }
        }
        return gain;
    }
}
