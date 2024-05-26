/* PROBLEM DESCRIPTION

An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

 

Example 1:

Input: nums = [1]

Output: true

Explanation:

There is only one element. So the answer is true.

Example 2:

Input: nums = [2,1,4]

Output: true

Explanation:

There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

Example 3:

Input: nums = [4,3,1,6]

Output: false

Explanation:

nums[1] and nums[2] are both odd. So the answer is false.

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

*/

//Solution

class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        for(int i = 1; i < nums.length; i++) {
            if((nums[i] % 2 == 0 && nums[i-1] % 2 != 0) || (nums[i] % 2 != 0 && nums[i-1] % 2 == 0)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}