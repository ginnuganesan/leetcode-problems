/* PROBLEM DESCRIPTION

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30

*/

//Solution

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        if (numRows >= 1) {
            out.add(List.of(1));
        }
        List<Integer> prev = List.of(1, 1);
        if (numRows >= 2) {
            out.add(prev);
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < prev.size()-1; j++) {
                list.add(prev.get(j) + prev.get(j+1));
            }
            list.add(1);
            out.add(list);
            prev = list;
        }
        return out;
    }
}
