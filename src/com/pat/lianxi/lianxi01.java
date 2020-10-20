package com.pat.lianxi;
/*
 * ������1����Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ����������º�ÿ��������һ�����ӣ�
 * �������Ӷ���������ÿ���µ���������Ϊ���٣�
 */
public class lianxi01 {
	int getTotal(int month){
		int f0=0,f1=2,f2=0,f3=0;
		
		while(month-->0){
			f0=f3/2;		
			f3=f3+f2;
			f2=f1;
			f1=f0;
			System.out.println(f1+""+f2+""+f3);
		}
		return f3+f2+f1;
	}
	public static void main(String[] args) {
		lianxi01 lx01=new lianxi01();
		for(int i=0;i<10;i++){
			System.out.println(lx01.getTotal(i)+"\n");	
		}
	}
}
