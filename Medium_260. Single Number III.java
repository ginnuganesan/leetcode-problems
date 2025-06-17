/* PROBLEM DESCRIPTION

Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each integer in nums will appear twice, only two integers will appear once.

*/

//Solution

class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2){
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int[] out = new int[2];
        int j = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                out[j] = entry.getKey();
                j++;
            }
        }
        return out;
    }
}

//Optimal solution [Bit Manipulation]

class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        int xor = 0;
        for (int num: nums) {
            xor ^= num;
        }
        int rightmostSetBit = (xor & xor-1) ^ xor;
        int bucket1 = 0, bucket2 = 0;
        for (int num: nums) {
            if ((num & rightmostSetBit) > 0) {
                bucket1 ^= num;
            } else {
                bucket2 ^= num;
            }
        }
        return new int[] {bucket1, bucket2};
    }
}
