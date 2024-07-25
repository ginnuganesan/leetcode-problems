/* PROBLEM DESCRIPTION

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104

*/

//Solution

class Solution {
    public int[] sortArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        merge(nums, l, r);
        return nums;
    }

    public void merge(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }

        int m = (l + r) / 2;

        merge(nums, l, m);
        merge(nums, m+1, r);

        mergeSort(nums, l, m, r);
    }

    public void mergeSort(int[] nums, int l, int m, int r) {
        List<Integer> temp = new ArrayList<>();

        int left = l, right = m+1;

        while(left <= m && right <= r) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while(left <= m) {
            temp.add(nums[left]);
            left++;
        }

        while(right <= r) {
            temp.add(nums[right]);
            right++;
        }

        for(int i = l; i <= r; i++) {
            nums[i] = temp.get(i-l);
        }
    }
}
