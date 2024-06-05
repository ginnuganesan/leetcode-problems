/* PROBLEM DESCRIPTION

Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.

*/

//Solution

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> out = new ArrayList<>();
        Map<Character, Integer> ref = getFrequency(words[0]);
        for(int i = 1; i < words.length; i++) {
            Map<Character, Integer> freq = getFrequency(words[i]);
            Set<Character> keysToRemove = new HashSet<>();
            for(char c: ref.keySet()) {
                if (freq.containsKey(c)) {
                    if(freq.get(c) < ref.get(c)) {
                        ref.put(c, freq.get(c));
                    }
                } else {
                    keysToRemove.add(c);
                }
            }
            for(Character ch: keysToRemove) {
                ref.remove(ch);
            }
        }
        for(Character c: ref.keySet()) {
            int length = ref.get(c);
            for(int j = 0; j < length; j++) {
                out.add(Character.toString(c));
            }
        }
        return out;
    }

    public Map<Character, Integer> getFrequency(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }
}
