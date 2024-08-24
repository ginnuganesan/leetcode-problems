/* PROBLEM DESCRIPTION

Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

The closest is defined as the absolute difference minimized between two integers.

 

Example 1:

Input: n = "123"
Output: "121"
Example 2:

Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.
 

Constraints:

1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 1018 - 1].

*/

//Solution

class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long actualClosest = -1;
        for(long candidate: getClosestPalindromes(n)) {
            if(actualClosest == -1 ||
                Math.abs(candidate - num) < Math.abs(actualClosest - num) ||
                (Math.abs(candidate - num) == Math.abs(actualClosest - num) && candidate < actualClosest)) {
                actualClosest = candidate;
            }
        }
        return Long.toString(actualClosest);
    }

    public Set<Long> getClosestPalindromes(String n) {
        Set<Long> candidates = new HashSet<>();
        int length = n.length();
        candidates.add((long)Math.pow(10, length - 1) - 1); //to add 9 or 99 or 999... to set
        candidates.add((long)Math.pow(10, length) + 1); //to add 11, 101, 1001, 10001... to set
        long firstHalf = Long.parseLong(n.substring(0, (length + 1) / 2));
        for(long i = firstHalf - 1; i <= firstHalf + 1; i++) {
            StringBuilder candidate = new StringBuilder();
            candidate.append(i);
            candidate.append(new StringBuilder(Long.toString(i)).reverse().substring(length % 2));
            candidates.add(Long.parseLong(candidate.toString()));
        }
        candidates.remove(Long.parseLong(n));
        return candidates;
    }
}
