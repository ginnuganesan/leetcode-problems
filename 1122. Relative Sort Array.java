/* PROBLEM DESCRIPTION

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
 

Constraints:

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.

*/

//Solution

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr1.length;
        for(int i = 0; i < n; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int[] sorted = new int[n];
        int k = 0;
        Set<Integer> a2Set = new HashSet<>();
        for(int i = 0; i < arr2.length; i++) {
            a2Set.add(arr2[i]);
            if(map.containsKey(arr2[i])) {
                for(int j = 0; j < map.get(arr2[i]); j++) {
                    sorted[k] = arr2[i];
                    k++;
                }
            }
        }
        int[] extra = new int[n-k];
        int l = 0;
        for(int i = 0; i < n; i++) {
            if(!a2Set.contains(arr1[i])) {
                extra[l] = arr1[i];
                l++;
            }
        }
        Arrays.sort(extra);
        for(int i = k; i < n; i++) {
            sorted[i] = extra[i-k];
        }
        return sorted;
    }
}
