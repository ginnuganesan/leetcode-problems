/* PROBLEM DESCRIPTION

Given a string s, return the maximum length of a 
substring
 such that it contains at most two occurrences of each character.
 

Example 1:

Input: s = "bcbbbcba"

Output: 4

Explanation:

The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
Example 2:

Input: s = "aaaa"

Output: 2

Explanation:

The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
 

Constraints:

2 <= s.length <= 100
s consists only of lowercase English letters.

*/

//Solution

class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        int maxLength = 0;
        int count = 0, i = 0, j = i;
        while(i < s.length() && j < s.length()) {
            char currentChar = s.charAt(j);
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);
            if(charFrequency.get(currentChar) <= 2) {
                count++;
                j++;
            } else {
                maxLength = Math.max(maxLength, count);
                count = 0;
                charFrequency = new HashMap<>();
                i++;
                j = i;
            }
        }
        maxLength = Math.max(maxLength, count);
        return maxLength;
    }
}
