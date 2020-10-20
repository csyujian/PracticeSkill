package com.pat.lianxi;
/*
 * ��Ŀ����s=a+aa+aaa+aaaa+aa...a��ֵ��
 * ����a��һ�����֡�����2+22+222+2222+22222
 * (��ʱ����5�������)������������м��̿��ơ�
 */
public class lianxi08 {
	static int f(int m,int n){
		int sum=0,t=0;
		while(t<n){
			sum+=m;
			m=m*10+m;
			t++;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(f(3, 2));
	}	
}
