/* PROBLEM DESCRIPTION

Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104

*/

//Solution

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 1;
        while(list.size() < n) {
            list.add(num);
            if(num * 10 <= n) {
                num *= 10;
            } else {
                while(num % 10 == 9 || num == n) {
                    num /= 10;
                }
                num++;
            }
        }
        return list;
    }
}
