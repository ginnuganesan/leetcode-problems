/* PROBLEM DESCRIPTION

A word is considered valid if:

It contains a minimum of 3 characters.
It consists of the digits 0-9, and the uppercase and lowercase English letters. (Not necessary to have all of them.)
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.

Return true if word is valid, otherwise, return false.

Notes:

'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.
 

Example 1:

Input: word = "234Adas"

Output: true

Explanation:

This word satisfies the conditions.

Example 2:

Input: word = "b3"

Output: false

Explanation:

The length of this word is fewer than 3, and does not have a vowel.

Example 3:

Input: word = "a3$e"

Output: false

Explanation:

This word contains a '$' character and does not have a consonant.

 

Constraints:

1 <= word.length <= 20
word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.

*/

//Solution

class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) {
            return false;
        }
        boolean isVow = false, isCons = false, isSp = false;
        for(int i = 0; i < word.length(); i++) {
            isVow = isVowel(word.charAt(i));
            if(isVow) {
                break;
            }
        }
        for(int i = 0; i < word.length(); i++) {
            isCons = isConsonant(word.charAt(i));
            if(isCons) {
                break;
            }
        }
        for(int i = 0; i < word.length(); i++) {
            isSp = isSpecial(word.charAt(i));
            if(isSp) {
                break;
            }
        }
        if(isSp) {
            return false;
        }
        if(isVow && isCons) {
            return true;
        }
        return false;
    }
    
    public boolean isVowel(char ch) {
        String str = "aeiouAEIOU";
        return (str.indexOf(ch) != -1) ? true : false;
    }
    
    public boolean isConsonant(char ch) {
        String str = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        return (str.indexOf(ch) != -1) ? true : false;
    }
    
    public boolean isSpecial(char ch) {
        String str = "@#$";
        return (str.indexOf(ch) != -1) ? true : false;
    }
}
