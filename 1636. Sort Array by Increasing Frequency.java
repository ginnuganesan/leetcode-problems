/* PROBLEM DESCRIPTION

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100

*/

//Solution

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> sorted = sortByValueThenKey(freq);
        int j = 0;
        for(Integer key: sorted.keySet()) {
            for(int i = 0; i < sorted.get(key); i++) {
                nums[j] = key;
                j++;
            }
        }
        return nums;
    }

    public Map<Integer, Integer> sortByValueThenKey(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                int valueComparison = entry1.getValue().compareTo(entry2.getValue());
                if (valueComparison != 0) {
                    return valueComparison;
                } else {
                    return entry2.getKey().compareTo(entry1.getKey()); // Descending order of keys
                }
            }
        });

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
