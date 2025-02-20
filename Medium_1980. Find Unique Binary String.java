/* PROBLEM DESCRIPTION

Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 

Constraints:

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique.

*/

//Solution

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        List<Integer> decimals = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            decimals.add(binaryToDec(nums[i], n));
        }
        for(int i = 0; i < Math.pow(2, n); i++) {
            if(!decimals.contains(i)) {
                return decimalToBinary(i, n);
            }
        }
        return "";
    }

    private int binaryToDec(String binary, int n) {
        int decimalNumber = 0;
        int power = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimalNumber += (int) Math.pow(2, power);
            }
            power++;
        }
        return decimalNumber;
    }

    private String decimalToBinary(int decimal, int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int k = decimal >> i;
            if ((k & 1) > 0)
                binary.append("1");
            else
                binary.append("0");
        }
        return binary.substring(binary.length() - n);
    }
}
