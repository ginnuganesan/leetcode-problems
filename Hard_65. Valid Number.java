/* PROBLEM DESCRIPTION

Given a string s, return whether s is a valid number.

For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".

Formally, a valid number is defined using one of the following definitions:

An integer number followed by an optional exponent.
A decimal number followed by an optional exponent.
An integer number is defined with an optional sign '-' or '+' followed by digits.

A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:

Digits followed by a dot '.'.
Digits followed by a dot '.' followed by digits.
A dot '.' followed by digits.
An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.

The digits are defined as one or more digits.

 

Example 1:

Input: s = "0"

Output: true

Example 2:

Input: s = "e"

Output: false

Example 3:

Input: s = "."

Output: false

 

Constraints:

1 <= s.length <= 20
s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.

*/

//Solution

class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        if(n == 1 & s.charAt(0) == '.') {
            return false;
        }
        if(!(Character.isDigit(s.charAt(0)) || s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == '.')
            || (s.contains("--") || s.contains("-+") || s.contains("+-") || s.contains("++") || s.contains("..") || s.startsWith(".e"))
            || (s.contains("ee") || s.contains("EE") || s.contains("eE") || s.contains("Ee"))
            || !(Character.isDigit(s.charAt(n-1)) || s.charAt(n-1) == '.')) {
            return false;
        }
        int indexOfDot = s.lastIndexOf(String.valueOf('.'));
        int indexOfE = Math.max(s.lastIndexOf(String.valueOf('e')), s.lastIndexOf(String.valueOf('E')));
        if(indexOfE != -1 && indexOfDot > indexOfE) {
            return false;
        }
        if(indexOfE != -1) {
            int digitCountBeforeE = 0;
            for(int i = 0; i < indexOfE; i++) {
                if(Character.isDigit(s.charAt(i))) {
                    digitCountBeforeE++;
                }
            }
            if(digitCountBeforeE == 0) {
                return false;
            }
        }
        for(int i = 0; i < n; i++) {
            if(Character.isLetter(s.charAt(i)) && !(s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                return false;
            }
        }
        int countOfDots = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '.') {
                countOfDots++;
            }
            if(countOfDots > 1) {
                return false;
            }
        }
        int countOfE = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                countOfE++;
            }
            if(countOfE > 1) {
                return false;
            }
        }
        if(s.lastIndexOf("+") > 0 || (s.lastIndexOf("-") > 0)) {
            int index = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
            if(!(s.charAt(index-1) == 'e' || s.charAt(index-1) == 'E')) {
                return false;
            }
        }
        int digitCount = 0;
        for(int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))) {
                digitCount++;
            }
        }
        if(digitCount == 0) {
            return false;
        }
        return true;
    }
}
