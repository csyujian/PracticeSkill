package com.pat.lianxi;
/*
 * ��Ŀ������һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
 */
public class lianxi07 {
	static void f(String aString){
		int space=0,number=0,letter=0,other=0;
		for(int i=0;i<aString.length();i++){
			if((aString.charAt(i)>='A'&&aString.charAt(i)<='Z')||(aString.charAt(i)>='a'&&aString.charAt(i)<='z')){
				letter++;
			}else if(aString.charAt(i)==' '){
				space++;
			}else if(aString.charAt(i)>='0'&&aString.charAt(i)<='9'){
				number++;
			}else {
				other++;
			}
		}
		System.out.println(space+","+number+","+letter+","+other);
	}
	public static void main(String[] args) {
		f("asdb2345gvb5632 -=");
	}
}
