package com.pat;

class ReverseWords {
    static boolean isReply(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    static String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        String res=s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(res.length()<j-i+1&&isReply(s,i,j)){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }
    static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
	        if(s == null || "".equals(s.trim())){
	            return "";
	        }
	        
	        String[] str = s.trim().split(" +");
	        for(int i = str.length-1; i >= 0; i--){
	            if(i == 0){
	                sb.append(str[i]);
	            }else{
	                sb.append(str[i]).append(" ");
	            }
	        }
	        return sb.toString();
    }
    public static void main(String[] args) {
		String string="cbba";
		System.out.println("longest:"+longestPalindrome(string));
		System.out.println("reverse:"+reverseWords("abc    acc asss"));
	}
    
}
