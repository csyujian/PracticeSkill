package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/26 22:50
 */
public class lc71 {

    public String simplifyPath(String path) {
        StringBuffer sb = new StringBuffer();
        char[] str = path.toCharArray();
        int len = str.length;
        int slow = 1,count = 0;
        sb.append(str[0]);
        boolean flag = false;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 1; i < len; i++){
            if(str[i] == '/'){
                if(count == 0){

                }else if(flag){
                    if(count == 2){
                        if(stack.size() > 0){
                            int removelen = stack.poll();
                            int start = sb.length() - removelen - 1;
                            sb.delete(start,sb.length());
                        }

                    }
                }else{
                    sb.append(str[i]);
                    stack.offer(count);
                }
                count = 0;
                flag = false;
            }else if(str[i] == '.'){
                flag = true;
                count++;
            }else{
                count++;
                sb.append(str[i]);
            }
        }
        if(str[str.length - 1] != '/'){
            if(flag == true){
                if(count == 2){
                    if(stack.size() > 0){
                        int removelen = stack.poll();
                        int start = sb.length() - removelen - 1;

                        sb.delete(start,sb.length());
                    }
                }
            }
        }
        if(sb.charAt(sb.length() - 1) == '/' && sb.length() > 1){
            sb.delete(sb.length() - 1,sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc71 s = new lc71();
        s.simplifyPath("/../");
    }
}