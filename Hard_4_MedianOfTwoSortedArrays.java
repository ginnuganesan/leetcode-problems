/* PROBLEM DESCRIPTION

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

*/

//Solution

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Length = nums1.length;
        int n2Length = nums2.length;
        int mergeLength = n1Length + n2Length;
        int[] merge = new int[mergeLength];

        int n1Pos, n2Pos, merPos;
        n1Pos = n2Pos = merPos = 0;
        while (n1Pos < n1Length && n2Pos < n2Length) {
            if(nums1[n1Pos] < nums2[n2Pos]) {
                merge[merPos] = nums1[n1Pos];
                merPos++;
                n1Pos++;
            } else {
                merge[merPos] = nums2[n2Pos];
                merPos++;
                n2Pos++;
            }
        }
        while (n1Pos < n1Length) {
            merge[merPos] = nums1[n1Pos];
            merPos++;
            n1Pos++;
        }
        while (n2Pos < n2Length) {
            merge[merPos] = nums2[n2Pos];
            merPos++;
            n2Pos++;
        }
        if(mergeLength % 2 == 0) {
            System.out.println(merge[mergeLength/2 - 1]);
            System.out.println(merge[mergeLength/2]);
            return (double)(merge[mergeLength/2 - 1] + merge[mergeLength/2])/2;
        }
        return merge[mergeLength/2];
    }
}
