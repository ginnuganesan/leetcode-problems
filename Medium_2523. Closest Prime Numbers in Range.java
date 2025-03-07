/* PROBLEM DESCRIPTION

Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

 

Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
Example 2:

Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 

Constraints:

1 <= left <= right <= 106

*/

//Solution

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] primeArr = sieveOfEratosthenes(right + 1);
        int n1 = -1, n2 = -1;
        List<Integer> primesInRange = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if (primeArr[i]) {
                primesInRange.add(i);
            }
        }
        if (primesInRange.size() >= 2) {
            int minDiff = Integer.MAX_VALUE;
            for(int i = primesInRange.size() - 1; i >= 1; i--) {
                int diff = primesInRange.get(i) - primesInRange.get(i-1);
                if (diff <= minDiff) {
                    minDiff = diff;
                    n1 = primesInRange.get(i-1);
                    n2 = primesInRange.get(i);
                }
            }
        }
        return new int[] {n1, n2};
    }

    public boolean[] sieveOfEratosthenes(int n) {
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }
}
