package com.pat.lianxi;
/*
 * ��Ŀ����ӡ�����е� "ˮ�ɻ��� "����ν "ˮ�ɻ��� "��ָһ����λ����
 * ���λ���������͵��ڸ����������磺153��һ�� "ˮ�ɻ��� "��
 * ��Ϊ153=1�����η���5�����η���3�����η���
 */
public class lianxi03 {
	void shuixianhua(){
		int start=100,end=999;
		while(start<=end){
			isshuixianhua(start++);
			//System.out.println(start);
		}
	}
	void isshuixianhua(int n){
		int a,b,c;
		a=n%10;
		b=n%100/10;
		c=n/100;
		if(n==a*a*a+b*b*b+c*c*c){
			System.out.println(n);
			//return true;
		}
		//return false;
	}
	public static void main(String[] args) {
		new lianxi03().shuixianhua();
	}
}
