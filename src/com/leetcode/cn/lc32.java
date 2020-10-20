package com.leetcode.cn;

public class lc32 {
    public int longestValidParentheses(String s) {
        int res=0;
        int len=s.length();
        char[] ss=s.toCharArray();
        for(int i=0;i<len;i++){
            if(i>0&&ss[i]==')'){
                for(int j=i-1;j>=0;j--){
                    if(ss[j]=='('){
                        ss[j]='#';
                        ss[i]='#';
                        break;
                    }
                }
            }
        }
        int left=-1;
        for(int i=0;i<len;i++){
            if(ss[i]!='#'){
                res=Math.max(res,i-left-1);
                left=i;
            }
        }
        if(ss[len-1]=='#'){
            res=Math.max(res,len-left-1);
        }
        return res;
    }
    public static void main(String[] args) {
		int res=new lc32().longestValidParentheses(")()())()))((())()()()");
		System.out.println(res);
		
	}
}
