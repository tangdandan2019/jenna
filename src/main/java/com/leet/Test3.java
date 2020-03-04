package com.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑块问题：求字符串中最短的不重复的子串
 * @Author: Tang dandan
 * @Date: 2020/1/30 14:51
 */

public class Test3 {

    public static void main(String[] args) {
     String a = "ababbaba";
     int n = lengthOfLongestSubstring(a);
     System.out.println("n = " + n);
    }

    /**
     * 求不重复字符串的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
     int n = s.length() , ans = 0;
     Map<Character,Integer> map = new HashMap<>();
     for(int start = 0,end =0; end <n;end++)
     {
       char c = s.charAt(end);
        if(map.containsKey(c))
        {
            start = Math.max(map.get(c),start);
        }
        ans = Math.max(ans,end-start+1);
        map.put(s.charAt(end),end+1);
     }
     return ans;
    }
}
