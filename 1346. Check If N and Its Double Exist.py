''' PROBLEM DESCRIPTION

Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
 

Constraints:

2 <= arr.length <= 500
-103 <= arr[i] <= 103

'''

#Solution

class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        a = {arr[0]}
        for i in range(len(arr)):
            if arr[i] * 2 in a or (arr[i] % 2 == 0 and arr[i] // 2 in a):
                return True
            a.add(arr[i])
        return False
