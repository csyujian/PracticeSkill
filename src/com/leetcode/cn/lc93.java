package com.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

class lc93 {
    private List<String> result = new ArrayList<>();
    private char[] tmp;

    public List<String> restoreIpAddresses(String s) {
        tmp = new char[s.length() + 3];
        backtrace(s, 0, 0);
        return result;
    }

    private void backtrace(String s, int start, int step) {
        int n = s.length();
        if (n - start < 4 - step || n - start > (4 - step) * 3) return;
        if (step == 4) {
            result.add(new String(tmp));
            return;
        }
        if (step > 0) tmp[start + step - 1] = '.';
        tmp[start + step] = s.charAt(start);
        backtrace(s, start + 1, step + 1);
        if (s.charAt(start) == '0' || start >= n - 1) return;
        tmp[start + step + 1] = s.charAt(start + 1);
        backtrace(s, start + 2, step + 1);
        if (start + 2 >= n) return;
        tmp[start + step + 2] = s.charAt(start + 2);
        if ((s.charAt(start) - '0') * 100 + (s.charAt(start + 1) - '0') * 10 + s.charAt(start + 2) - '0' <= 255) {
            backtrace(s, start + 3, step + 1);
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = new lc93().restoreIpAddresses(s);
        for(int i = 0 ;i<res.size();i++) {
            System.out.println(res.get(i));
        }
        StringBuilder sb = new StringBuilder();
        sb.length();
    }

}