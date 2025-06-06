/* PROBLEM DESCRIPTION

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

*/

//Solution

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int out = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                out = entry.getKey();
            }
        }
        return out;
    }
}

//Optimal solution

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num: nums) {
            xor ^= num; // 2 ^ 2 = 0 or 3 ^ 3 = 0 so these will become 0 
                        // and only single element prevails
        }
        return xor;
    }
}
