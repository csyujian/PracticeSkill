package com.leetcode.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/26 23:38
 */
public class lc76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int tlen = t.length();
        char[] str = s.toCharArray();
        int slow = 0;
        String res = new String(s);
        for(int fast = 0;fast < str.length;fast++){
            if(map.containsKey(str[fast])){
                map.put(str[fast],map.get(str[fast]) - 1);
                if(map.get(str[fast]) >= 0){
                    tlen--;
                }
                if(tlen == 0){
                    while (slow <= fast) {
                        if (map.containsKey(str[slow])) {
                            if (map.get(str[slow]) >= 0) {
                                break;
                            } else {
                                map.put(str[slow], map.get(str[slow]) + 1);
                            }
                        }
                        slow++;
                    }
                    if(fast - slow + 1 < res.length()){
                        res = s.substring(slow,fast + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc76 s = new lc76();
        String res = s.minWindow("ADOBECODEBANC","ABC");
        System.out.println(res);
    }
}
