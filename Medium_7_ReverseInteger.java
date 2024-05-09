/* PROBLEM DESCRIPTION

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1

*/

//Solution

class Solution {
    public int reverse(int x) {
        long sum = 0L;
        while(x != 0) {
            long mod = x % 10;
            sum = (sum * 10) + mod;
            x = x/10;
        }
        return (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) ? 0 : (int)sum;
    }
}
