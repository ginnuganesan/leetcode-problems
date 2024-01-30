/* PROBLEM DESCRIPTION

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/

//Solution

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        if(strs.length == 1) {
            List<String> list = new ArrayList<String>();
            list.add(strs[0]);
            out.add(list);
        } else {
            Map<String, List<String>> map = new HashMap<>();
            for(String s: strs) {
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                String sorted = new String(arr);
                if(map.containsKey(sorted)){
                    List<String> list = map.get(sorted);
                    list.add(s);
                    map.put(sorted, list);
                }
                else{
                    List<String> list = new ArrayList<String>();
                    list.add(s);
                    map.put(sorted, list);
                }
            }
            for(Map.Entry<String, List<String>> entry: map.entrySet()) {
                out.add(entry.getValue());
            }
        }
        return out;
    }
}
