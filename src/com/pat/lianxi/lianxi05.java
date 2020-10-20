package com.pat.lianxi;
/*
 * ��Ŀ�����������������Ƕ������ɴ��⣺ѧϰ�ɼ�> =90�ֵ�ͬѧ��A��ʾ��60-89��֮�����B��ʾ��60�����µ���C��ʾ��
 */
public class lianxi05 {
	static char f(int n){
		return n>=90?'A':(n>=60?'B':'C'); 
	}
	public static void main(String[] args) {
		System.out.println(f(30));
	}
}
