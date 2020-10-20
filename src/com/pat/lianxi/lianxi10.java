package com.pat.lianxi;
/*
 * ��Ŀ��һ���100�׸߶��������£�
 * ÿ����غ�����ԭ�߶ȵ�һ�룻�����£�
 * �����ڵ�10�����ʱ�������������ף���10�η�����ߣ�
 */
public class lianxi10 {
	static double f(int times){
		double sum=0;
		int t=0,c=100;
		while(t<times){
			sum+=(c/=2);
			t++;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(f(100));
	}
}
