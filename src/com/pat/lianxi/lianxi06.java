package com.pat.lianxi;
/*
 * ��Ŀ����������������m��n���������Լ������С��������
 */
public class lianxi06 {
	static int f(int m,int n){
		int p=2,q=1;
		while(p<=m&&p<=n){
			if(m%p==0&&n%p==0){
				q*=p;
				m/=p;
				n/=p;
			}else{
				p++;
			}
		}
		System.out.println(q+""+q*m*n);
		return 0;
	}
	public static void main(String[] args) {
		f(15,20);
	}
	
}
