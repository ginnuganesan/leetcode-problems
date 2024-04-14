/* PROBLEM DESCRIPTION

You are given a string s representing a 12-hour format time where some of the digits (possibly none) are replaced with a "?".

12-hour times are formatted as "HH:MM", where HH is between 00 and 11, and MM is between 00 and 59. The earliest 12-hour time is 00:00, and the latest is 11:59.

You have to replace all the "?" characters in s with digits such that the time we obtain by the resulting string is a valid 12-hour format time and is the latest possible.

Return the resulting string.

 

Example 1:

Input: s = "1?:?4"

Output: "11:54"

Explanation: The latest 12-hour format time we can achieve by replacing "?" characters is "11:54".

Example 2:

Input: s = "0?:5?"

Output: "09:59"

Explanation: The latest 12-hour format time we can achieve by replacing "?" characters is "09:59".

 

Constraints:

s.length == 5
s[2] is equal to the character ":".
All characters except s[2] are digits or "?" characters.
The input is generated such that there is at least one time between "00:00" and "11:59" that you can obtain after replacing the "?" characters.

*/

//Solution

class Solution {
    public String findLatestTime(String s) {
        StringBuilder out = new StringBuilder();
        if(s.charAt(0) == '0' && s.charAt(1) == '?') {
            out.append("09:");
        } else if (s.charAt(0) == '?' && (s.charAt(1) == '0' || s.charAt(1) == '1')) {
            out.append("1" + String.valueOf(s.charAt(1)) + ":");
        } else if (s.charAt(0) == '?' && s.charAt(1) != '?') {
            out.append("0" + String.valueOf(s.charAt(1)) + ":");
        } else if ((s.charAt(0) == '1' && s.charAt(1) == '?') || (s.charAt(0) == '?' && s.charAt(1) == '?')) {
            out.append("11:");
        } else {
            out.append(s.split(":")[0] + ":");
        }
        if(s.charAt(3) != '?' && s.charAt(4) == '?') {
            out.append(String.valueOf(s.charAt(3)) + "9");
        } else if (s.charAt(4) != '?' && s.charAt(3) == '?') {
            out.append("5"+ String.valueOf(s.charAt(4)));
        } else if (s.charAt(3) == '?' && s.charAt(4) == '?') {
            out.append("59");
        } else {
            out.append(s.split(":")[1]);
        }
        return out.toString();
    }
}
