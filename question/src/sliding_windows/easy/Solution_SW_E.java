package sliding_windows.easy;

import java.util.*;

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

    public int findMin(int[] s, int k){
        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        int count = 0;
        while (right< s.length){
            sum += s[right];
            count++;
            if(count==k){
                max = Math.max(max,sum);
                count--;
                sum-=s[left];
                left++;
            }
            right++;
        }
        return max;
    }

    public int minimumDifference(int[] nums, int k) {
//        1984. Minimum Difference Between Highest and Lowest of K Scores
//                Easy
//        562
//        92
//        Companies
//        You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.
//
//                Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.
//
//                Return the minimum possible difference.
//
//
//
//        Example 1:
//
//        Input: nums = [90], k = 1
//        Output: 0
//        Explanation: There is one way to pick score(s) of one student:
//        - [90]. The difference between the highest and lowest score is 90 - 90 = 0.
//        The minimum possible difference is 0.
//        Example 2:
//
//        Input: nums = [9,4,1,7], k = 2
//        Output: 2
//        Explanation: There are six ways to pick score(s) of two students:
//        - [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
//                - [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
//                - [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
//                - [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
//                - [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
//                - [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
//        The minimum possible difference is 2.

//        87063,61094,44530,21297,95857,93551,9918
//        if (nums.length == 1 && (k == 1)) return 0;
//        int min = Integer.MAX_VALUE;
//        nums = Arrays.stream(nums).sorted().toArray();
//        int left = 0 , right = 1 , diff = 0,count =1;
//        while (left < right && right < nums.length){
//            diff = Math.abs(nums[left]-nums[right]);
//            count++;
//            if(count == k ) {
//                min = Math.min(min, diff);
//                count--;
//            }
//            if (right == nums.length-1){
//                left++;
//                right=left+1;
//                continue;
//            }
//            right++;
//        }
//        return  min;

            if(k == 1)return 0;
            int i = 0,j = k-1,res = Integer.MAX_VALUE;

            Arrays.sort(nums);
            while(j < nums.length){
                res = Math.min(res,nums[j] - nums[i]);
                j++;
                i++;
            }

            return res;

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        219. Contains Duplicate II
//                Easy
//        4.2K
//        2.4K
//                Companies
//        Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//
//
//
//                Example 1:
//
//        Input: nums = [1,2,3,1], k = 3
//        Output: true
//        Example 2:
//
//        Input: nums = [1,0,1,1], k = 1
//        Output: true
//        Example 3:
//
//        Input: nums = [1,2,3,1,2,3], k = 2
//        Output: false

//        int left = 0,   right=1;
//        while(left < right && right< nums.length){
//            if (nums[left] ==  nums[right] && Math.abs(left -right )<=k) {
//                return true;
//            }
//            if (right == nums.length-1){
//                left++;
//                right=left+1;
//                continue;
//            }
//            right++;
//        }
//        return false;

        //num,pos
        Map<Integer,Integer> map = new HashMap<>();

        for (int i =0; i< nums.length;i++){
            if (map.containsKey(nums[i]) &&
                    (Math.abs(map.get(nums[i])-i ) <=k)){
                return true;
            }
            map.put(nums[i],i);
        }


        return false;



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