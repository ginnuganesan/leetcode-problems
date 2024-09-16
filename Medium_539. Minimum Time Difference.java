/* PROBLEM DESCRIPTION

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 

Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".

*/

//Solution

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutePoints = new ArrayList<>();
        for(String time: timePoints) {
            minutePoints.add(Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3)));
        }
        Collections.sort(minutePoints);
        minutePoints.add(minutePoints.get(0) + 24 * 60);
        int minDiff = 24*60;
        for(int i = 1; i < minutePoints.size(); i++) {
            minDiff = Math.min(minDiff, minutePoints.get(i) - minutePoints.get(i-1));
        }
        return minDiff;
    }
}
