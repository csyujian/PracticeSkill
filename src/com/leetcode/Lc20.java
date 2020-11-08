package com.leetcode;

import java.util.Stack;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/14 7:02
 */
public class Lc20 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for(char ch : s.toCharArray()){
            if(ch == ')' || ch == ']' || ch == '}'){
                if(!isMatch(ch,stack.pop())){
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return !stack.isEmpty() && (stack.pop() == '#');
    }
    public boolean isMatch(char s,char t){
        if(s == ')'){
            return t =='(';
        }else if ( s == '}'){
            return t == '{';
        }else if(s == ']'){
            return t == '[';
        }
        return false;
    }

    public static void main(String[] args) {
        Lc20 s = new Lc20();
        boolean res = s.isValid("()");
        System.out.println(res);
        System.out.println(s.isValid("(]"));
        
    }
}
