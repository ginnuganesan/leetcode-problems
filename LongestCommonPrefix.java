/*PROBLEM DESCRIPTION

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

*/

//Solution

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String output = "";
        String shortStr = strs[0];
        for(String str: strs){
            int minlength = Math.min(shortStr.length(), str.length());
            if(shortStr.length() == minlength){
                shortStr = shortStr;
            }
            else {
                shortStr = str;
            }
        }
        for(int i = 0; i < shortStr.length(); i++) {
            char ch = shortStr.charAt(i);
            for(String str: strs) {
                if(str.charAt(i) != ch){
                    return output;
                }
            }
            output += ch;
        }
        return output;
    }
}
