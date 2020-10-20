package com.pat.lianxi;
/*
 * ��Ŀ��һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ "���� "������6=1��2��3.����ҳ�1000���ڵ�����������
 */
public class lianxi09 {
	static void f(){
		for(int i=1;i<1001;i++){
			if(isPerfectNumber(i)){
				System.out.println(i);
			}
		}
	}
	static boolean isPerfectNumber(int n){
		int sum=1,t=2;
		while(t<n){
			if(n%t==0){
				sum+=t;
			}
			t++;
		}
		return sum==n;
	}
	public static void main(String[] args) {
		f();
	}
}
