package sliding_windows.easy;

import java.util.*;

public class Solution_SW_M {
    public int noRepeatedCharacter(String s , int k ){
        if (s == null || s.length() < k)
            return 0;
        int res= 0;
        int left = 0 , right =  1, count = 1  ;

        Set<Character> map = new HashSet<>();
        map.add(s.charAt(left));

        while(left <= right && right < s.length()){
            map.add(s.charAt(right));
            count++;
            if (count == k){
                if (map.size() == k )  res++;
                count = 1;
                left++;
                right= left+1;
                map = new HashSet<>();
                map.add(s.charAt(left));
                continue;
            }
            right++;
        }

        return res;
    }
}