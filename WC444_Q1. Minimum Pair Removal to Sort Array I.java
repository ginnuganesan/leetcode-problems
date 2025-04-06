/* PROBLEM DESCRIPTION

Given an array nums, you can perform the following operation any number of times:

Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
Replace the pair with their sum.
Return the minimum number of operations needed to make the array non-decreasing.

An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).

 

Example 1:

Input: nums = [5,2,3,1]

Output: 2

Explanation:

The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
The array nums became non-decreasing in two operations.

Example 2:

Input: nums = [1,2,2]

Output: 0

Explanation:

The array nums is already sorted.

 

Constraints:

1 <= nums.length <= 50
-1000 <= nums[i] <= 1000

*/

//Solution

class Solution {
    public int minimumPairRemoval(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }
        int count = 0;
        while(!isSorted(list)) {
            int minSum = list.get(0) + list.get(1);
            int index1 = 0, index2 = 1;
            for(int i = 1; i < list.size()-1; i++) {
                int sum = list.get(i) + list.get(i+1);
                if (sum < minSum) {
                    minSum = sum;
                    index1 = i;
                    index2 = i+1;
                }
            }
            list.set(index1, minSum);
            list.remove(index2);
            count++;
        }
        return count;
    }

    public boolean isSorted(List<Integer> list) {
        for(int i = 0; i < list.size()-1; i++) {
            if(list.get(i+1) < list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
