/* PROBLEM DESCRIPTION

You are given an integer array nums containing positive integers. We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x. For example, encrypt(523) = 555 and encrypt(213) = 333.

Return the sum of encrypted elements.

 

Example 1:

Input: nums = [1,2,3]

Output: 6

Explanation: The encrypted elements are [1,2,3]. The sum of encrypted elements is 1 + 2 + 3 == 6.

Example 2:

Input: nums = [10,21,31]

Output: 66

Explanation: The encrypted elements are [11,22,33]. The sum of encrypted elements is 11 + 22 + 33 == 66.

 

Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= 1000

*/

//Solution

class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += encrypt(nums[i]);
        }
        return sum;
    }
    
    public int encrypt(int num) {
        int temp = num;
        int max = Integer.MIN_VALUE;
        int digit = 0;
        while(temp > 0) {
            int rem = temp % 10;
            max = Math.max(max, rem);
            temp = temp/10;
            ++digit;
        }
        if(digit == 1) {
            return num;
        }
        int newNum = 0;
        for(int i = 0; i < digit; i++) {
            newNum = (newNum * 10) + max;
        }
        return newNum;
    }
}
