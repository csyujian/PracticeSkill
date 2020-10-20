package com.leetcode.cn;

public class lc5843 {
    public String makeGood(String s){
        int len = s.length();
        if(len == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        int j = 0;
        for(int i = 0;i<len;i++){
            if(isSame(sb.charAt(j),s.charAt(i))){
                sb.deleteCharAt(j);
                j--;
            }else{
                sb.append(s.charAt(i));
                j++;
            }
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
    private boolean isSame(char a,char b){
        if(a >= 'a' && a <= 'z' && b <= 'Z' && b >= 'A'){
            return a - 'a' == b - 'A';
        }else if(b >= 'a' && b <= 'z' && a <= 'Z' && a >= 'A'){
            return b - 'a' == a - 'A';
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abBAcC";
        String s2=  "leEeetcode";
        String res = new lc5843().makeGood(s2);
        System.out.println(res);
    }
}
