/* PROBLEM DESCRIPTION

You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters in word are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

No character in word appears in uppercase.

Example 3:

Input: word = "abBCab"

Output: 1

Explanation:

The only special character in word is 'b'.

 

Constraints:

1 <= word.length <= 50
word consists of only lowercase and uppercase English letters.

*/

//Solution

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Integer> set = new HashSet<>();
        int out = 0;
        for(int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            if(!set.contains(ascii)) {
                if((ascii >= 97 && set.contains(ascii - 32)) || (ascii >= 65 && ascii <=90 && set.contains(ascii + 32))) {
                    out++;
                }
                set.add(ascii);
            }
        }
        return out;
    }
}
