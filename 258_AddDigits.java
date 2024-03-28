/* PROBLEM DESCRIPTION

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 

Constraints:

0 <= num <= 231 - 1

*/

//Solution

class Solution {
    public int addDigits(int num) {
        int noOfDigits = numOfDigits(num);
        if(noOfDigits == 1)
            return num;
        int newNum = add(num);
        noOfDigits = numOfDigits(newNum);
        while(noOfDigits > 1) {
            newNum = add(newNum);
            noOfDigits = numOfDigits(newNum);
        }
        return newNum;
    }

    public int numOfDigits(int num) {
        int temp = num;
        int count = 0;
        while(temp > 0) {
            temp = temp/10;
            count++;
        }
        return count;
    }

    public int add(int num) {
        int temp = num;
        int sum = 0;
        int rem = 0;
        while(temp > 0) {
            rem = temp % 10;
            temp = temp/10;
            sum += rem;
        }
        return sum;
    }

}
