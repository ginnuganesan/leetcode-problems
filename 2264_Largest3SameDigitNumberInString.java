/* PROBLEM DESCRIPTION

You are given a string num representing a large integer. An integer is good if it meets the following conditions:

It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.

Note:

A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.
 

Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 

Constraints:

3 <= num.length <= 1000
num only consists of digits.

*/

//Solution

class Solution {
    public String largestGoodInteger(String num) {
        List<String> ref = new ArrayList<>();
        ref.add("999");
        ref.add("888");
        ref.add("777");
        ref.add("666");
        ref.add("555");
        ref.add("444");
        ref.add("333");
        ref.add("222");
        ref.add("111");
        ref.add("000");
        for(int i = 0; i < 10; i++) {
            if(num.contains(ref.get(i))) {
                return ref.get(i);
            }
        }
        return "";
    }
}
