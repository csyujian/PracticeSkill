package com.pat;

class LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) {
            return "";
        }
        for (int i = 0 ;;i++) {
            char ch = strs[0].charAt(i);
            for(int j = 1 ;j < strs.length;j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i );
                }
            }
        }
    }
    public static void main(String[] args) {
    	String[] strs={"abc","abcd","abdd","aa","bb"};
		System.out.println(longestCommonPrefix(strs));
	}
}
