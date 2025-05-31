/* PROBLEM DESCRIPTION

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-2^31 <= dividend, divisor <= 2^31 - 1
divisor != 0

*/

//Solution

class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        if ((dividend < 0 && divisor > 0)
            || (dividend >= 0 && divisor < 0)) {
            sign = false;
        }
        long num = Math.abs((long)dividend);
        long den = Math.abs((long)divisor);
        long res = 0;
        while (num >= den) {
            long count = 0;
            while (num >= (den << (count+1))) { //den * 2 ^ (count + 1)
                count++;
            }
            res += (1L << count); //2 ^ count
            num -= (den << count); //den * 2 ^ count 
        }
        if (res >= 1L << 31 && sign) {
            return Integer.MAX_VALUE;
        }
        if (res >= 1L << 31 && !sign) {
            return Integer.MIN_VALUE;
        }
        return sign ? (int)res : (int)(-1 * res);
    }
}
