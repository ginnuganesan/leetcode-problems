''' PROBLEM DESCRIPTION

You are given two strings s and t, both of which are anagrams of each other, and an integer k.

Your task is to determine whether it is possible to split the string s into k equal-sized substrings, rearrange the substrings, and concatenate them in any order to create a new string that matches the given string t.

Return true if this is possible, otherwise, return false.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

A substring is a contiguous non-empty sequence of characters within a string.

 

Example 1:

Input: s = "abcd", t = "cdab", k = 2

Output: true

Explanation:

Split s into 2 substrings of length 2: ["ab", "cd"].
Rearranging these substrings as ["cd", "ab"], and then concatenating them results in "cdab", which matches t.
Example 2:

Input: s = "aabbcc", t = "bbaacc", k = 3

Output: true

Explanation:

Split s into 3 substrings of length 2: ["aa", "bb", "cc"].
Rearranging these substrings as ["bb", "aa", "cc"], and then concatenating them results in "bbaacc", which matches t.
Example 3:

Input: s = "aabbcc", t = "bbaacc", k = 2

Output: false

Explanation:

Split s into 2 substrings of length 3: ["aab", "bcc"].
These substrings cannot be rearranged to form t = "bbaacc", so the output is false.
 

Constraints:

1 <= s.length == t.length <= 2 * 105
1 <= k <= s.length
s.length is divisible by k.
s and t consist only of lowercase English letters.
The input is generated such that s and t are anagrams of each other.

Note: Please do not copy the description during the contest to maintain the integrity of your submissions.©leetcode

'''

#Solution

class Solution:
    def isPossibleToRearrange(self, s: str, t: str, k: int) -> bool:
        n = len(s)
        s_length = n // k
    
        s_count_s = {}
        s_count_t = {}
    
        for i in range(0, len(s), s_length):
            s_s = s[i:i + s_length]
            s_t = t[i:i + s_length]
    
            s_count_s[s_s] = s_count_s.get(s_s, 0) + 1
            s_count_t[s_t] = s_count_t.get(s_t, 0) + 1
    
        for s, count in s_count_s.items():
            if s_count_t.get(s, 0) < count:
                return False
    
        return True
