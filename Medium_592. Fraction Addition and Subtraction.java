/* PROBLEM DESCRIPTION

Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

 

Example 1:

Input: expression = "-1/2+1/2"
Output: "0/1"
Example 2:

Input: expression = "-1/2+1/2+1/3"
Output: "1/3"
Example 3:

Input: expression = "1/3-1/2"
Output: "-1/6"
 

Constraints:

The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1, 10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

*/

//Solution

class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 2520;
        if(Character.isDigit(expression.charAt(0))) {
            expression = "+" + expression;
        }

        int i = 0, n = expression.length();
        while(i < n) {
            int sign = expression.charAt(i) == '-' ? -1 : 1;
            i++;
            int j = i;
            while(j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            String fraction = expression.substring(i,j);
            String[] fractionSplit = fraction.split("/");
            int currentNumerator = Integer.parseInt(fractionSplit[0]);
            int currentDenominator = Integer.parseInt(fractionSplit[1]);
            numerator += sign * currentNumerator * denominator / currentDenominator;
            i = j;
        }
        int gcd = findGcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
        return numerator + "/" + denominator;
    }

    public static int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
