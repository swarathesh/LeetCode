package sliding_windows.easy;

import java.util.ArrayList;
import java.util.List;

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

    public String longestNiceSubstring(String s) {
//        A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
//
//        Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
//
//
//
//        Example 1:
//
//        Input: s = "YazaAay"
//        Output: "aAa"
//        Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
//        "aAa" is the longest nice substring.
//                Example 2:
//
//        Input: s = "Bb"
//        Output: "Bb"
//        Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
//        Example 3:
//
//        Input: s = "c"
//        Output: ""
//        Explanation: There are no nice substrings.
        return null;
    }

    public int minimumRecolors(String s, int k) {
//        2379. Minimum Recolors to Get K Consecutive Black Blocks
//        Easy
//        375
//        12
//        Companies
//        You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
//
//        You are also given an integer k, which is the desired number of consecutive black blocks.
//
//        In one operation, you can recolor a white block such that it becomes a black block.
//
//        Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
//
//
//
//        Example 1:
//
//        Input: blocks = "WBBWWBBWBW", k = 7
//        Output: 3
//        Explanation:
//        One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
//        so that blocks = "BBBBBBBWBW".
//                It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
//                Therefore, we return 3.
//        Example 2:
//
//        Input: blocks = "WBWBBBW", k = 2
//        Output: 0
//        Explanation:
//        No changes need to be made, since 2 consecutive black blocks already exist.
//                Therefore, we return 0.
//
//
//        Constraints:
//
//        n == blocks.length
//        1 <= n <= 100
//        blocks[i] is either 'W' or 'B'.
//        1 <= k <= n

        int left = 0,count =0 , right = k ;
        List<Integer> ans = new ArrayList<>();
        while (right<=s.length()){
             count = countPattern(s,left,right);
             if((right-left) == count) return 0;
             ans.add((right-left)-count);
             left++;
             right++;
        }
        return ans.stream().sorted().toList().get(0);

    }

    public int countPattern(String s, int left, int right) {
        int l  = left;
        int b = 0 ;
        while (l < right){
            if (s.charAt(l) == 'B') b++;
            l++;
        }
        return b;
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