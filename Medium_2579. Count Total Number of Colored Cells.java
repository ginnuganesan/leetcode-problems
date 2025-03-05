/* PROBLEM DESCRIPTION

There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

At the first minute, color any arbitrary unit cell blue.
Every minute thereafter, color blue every uncolored cell that touches a blue cell.
Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.


Return the number of colored cells at the end of n minutes.

 

Example 1:

Input: n = 1
Output: 1
Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
Example 2:

Input: n = 2
Output: 5
Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5. 
 

Constraints:

1 <= n <= 105

*/

//Solution

class Solution {
    public long coloredCells(int n) {
        //The arithmetic progression (excluding the middle term) is: 1, 3, 5, 
        //and we thus have n - 1 = 3 terms. 
        //The sum of these terms is 1 + 3 + 5 = 9.
        //The middle term (the number of cells in the middle row) 
        //when n = 4 is 2 * 4 - 1 = 7.
        //Then, following the formula, we calculate: 
        //2 * (sum of first half) + (middle term).
        //Substituting the values, we get 2 * 9 + 7 = 18 + 7 = 25.
        return 2L * n * (n - 1) + 1;
    }
}
