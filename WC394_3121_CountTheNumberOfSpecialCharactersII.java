/* PROBLEM DESCRIPTION

You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

There are no special characters in word.

Example 3:

Input: word = "AbBCab"

Output: 0

Explanation:

There are no special characters in word.

 

Constraints:

1 <= word.length <= 2 * 105
word consists of only lowercase and uppercase English letters.

*/

//Solution

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Integer> set = new HashSet<>();
        int out = 0;
        int lowerCaseC = 99;
        int upperCaseC = 67;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            if(!set.contains(ascii)) {
                if((ascii >= 97 && set.contains(ascii - 32)) || (ascii >= 65 && ascii <=90 && set.contains(ascii + 32))) {
                    out++;
                }
                set.add(ascii);
            }
            if(ascii <= 90 && !map.containsKey(ascii)) {
                map.put(ascii, i);
            } else if (ascii >= 97) {
                map.put(ascii, i);   
            }
        }
        for(Integer key : map.keySet()) {
            if(key >= 97 && map.get(key - 32) != null) {
                if (map.get(key) > map.get(key - 32)){
                    out--;
                }
            }
        }
        return out < 0 ? 0 : out;
    }
}
