package com.leetcode.cn;

import java.io.PipedOutputStream;
import java.util.*;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/16 11:25
 */
public class lc948 {
    public int bagOfTokensScore(int[] tokens, int p) {
        if(tokens.length == 0){
            return 0;
        }
        Arrays.sort(tokens);

        int score = 0;
        int n = tokens.length;
        int left = 0,right = n - 1;
        if(tokens[0] > p){
            return 0;
        }
        p -= tokens[left];
        left++;
        score++;
        while(true){
            while(left <= right && tokens[left] <= p){
                score++;
                p -= tokens[left];
                left++;
            }
            if(left + 1 < right && tokens[left] <= p + tokens[right]){
                p = p + tokens[right] - tokens[left] ;
                left ++;
                right--;
            }else{
                break;
            }
        }
        System.out.println(left + " " + right);
        return score;
    }

    public static void main(String[] args) {
        int[] tokens = {0,6,37,39,42,45,49,52,59,68};
        int res = new lc948().bagOfTokensScore(tokens,99);
        System.out.println(res);
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y)-> y - x);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        queue.poll();
        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
        Set<Integer> set = new HashSet<>();
        for (Integer integer : set) {
            System.out.println(integer);
        }
        System.out.println(queue.peek());
        System.out.println(3 | 1);
    }
}