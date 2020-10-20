package com.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/16 9:36
 */
public class lc68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int len =  words.length;
        int[] lens = new int[len];

        int slow = 0,fast = 0,sum = 0;
        for(;fast < len ;fast++){
            sum += words[fast].length();
            if(sum + fast - slow > maxWidth){
                int spaces = maxWidth - (sum - words[fast].length());
                fast -= 1;


                String temp = Justify(words,slow,fast,maxWidth,spaces);
                sum = 0;
                res.add(temp);
                slow = fast + 1;
            }
            if (fast == len - 1){
                int spaces = maxWidth - sum - (fast - slow);
                StringBuilder sb = new StringBuilder();
                while (slow <= fast){
                    sb.append(words[slow]);
                    sb.append(" ");
                    slow++;
                }
                sb.append(" ".repeat(spaces));
                res.add(sb.toString());
            }
        }

        return res;
    }
    String Justify(String[] words,int start,int end,int maxWidth,int spaces){

        StringBuilder sb = new StringBuilder();
        if(end == start){
            sb.append(words[start]);
            for(int i = 0;i<spaces;i++){
                sb.append(' ');
            }
            return sb.toString();
        }

        int means = spaces / (end - start);
        int extra = spaces % (end - start);
        for (int i = start;i < end;i++){
            sb.append(words[i]);
            sb.append(" ".repeat(means + (extra > 0 ? 1 : 0)));
            extra--;
        }
        sb.append(words[end]);
        return sb.toString();
    }

    public static void main(String[] aergs) {
//        String[] strings = {"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art","is","everything","else","we","do"};
//        String[] strings = {"What","must","be","acknowledgment","shall","be"};
        lc68 s = new lc68();
        String[] strings = {"a"};
        List<String> res = s.fullJustify(strings,1);
        for(String  str : res){
            System.out.println(str);
        }
    }
}
