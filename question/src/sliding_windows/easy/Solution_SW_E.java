package sliding_windows.easy;

public class Solution_SW_E {
    public int countGoodSubstrings(String s) {
//        A string is good if there are no repeated characters.
//
//                Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
//
//                Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
//
//        A substring is a contiguous sequence of characters in a string.
//
//
//
//                Example 1:
//
//        Input: s = "xyzzaz"
//        Output: 1
//        Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
//                The only good substring of length 3 is "xyz".
//                Example 2:
//
//        Input: s = "aababcabc"
//        Output: 4
//        Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
//                The good substrings are "abc", "bca", "cab", and "abc".

        int left= 0, right = 2, count = 0 ;

        while(right < s.length()) {
            if (!isDuplicate(s,left, right)) count++;
            left++;
            right++;
        }

        return count;
    }

    private boolean isDuplicate(String s, int left, int right) {
        int[] chars = new int[128];
        while (left<=right){
            char c  = s.charAt(left);
            chars[c]++;
            if (chars[c]>1) return true;
            left++;
        }
        return false;
    }

}