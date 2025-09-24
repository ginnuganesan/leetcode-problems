''' PROBLEM DESCRIPTION

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
 

Constraints:

-2^31 <= numerator, denominator <= 2^31 - 1
denominator != 0

'''

#Solution

class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0:
            return '0'
        
        res = []

        if (numerator < 0 and denominator > 0) or (numerator > 0 and denominator < 0):
            res.append('-')

        dividend, divisor = abs(numerator), abs(denominator)

        res.append(str(dividend // divisor))

        rem = dividend % divisor

        if rem == 0:
            return "".join(res)

        res.append('.')

        rem_positions = {}

        while rem != 0:
            rem_positions[rem] = len(res)
            rem *= 10
            res.append(str(rem // divisor))
            rem %= divisor
            if rem in rem_positions:
                res.insert(rem_positions[rem], '(')
                res.append(')')
                break
        
        return ''.join(res)
            
