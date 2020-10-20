package com.pat.lianxi;
/*
 *  ��Ŀ����һ���������ֽ������������磺����90,��ӡ��90=233*5��
 *  �����������n���зֽ���������Ӧ���ҵ�һ����С������k��
 *  Ȼ������������ɣ�
 *   (1)����������ǡ����n��
 *  ��˵���ֽ��������Ĺ����Ѿ���������ӡ�����ɡ� 
 *  (2)���n <> k����n�ܱ�k��������Ӧ��ӡ��k��ֵ��
 *  ����n����k����,��Ϊ�µ���������n,�ظ�ִ�е�һ���� 
 *  (3)���n���ܱ�k����������k+1��Ϊk��ֵ,�ظ�ִ�е�һ����
 */
public class lianxi04 {
	public static void main(String[] args) {
		int n=100;
		int m=100;
		System.out.print(n+"=");
		String tString="";
		while(m!=1){
			for(int i=2;i<=Math.sqrt(m)||(i=m)>2;i++){
				if(m%i==0){
					if(isPrime(i)){
						m/=i;
						tString+=i+"*";
						i=1;
					}
				}
			}
		}
		System.out.print(tString.substring(0, tString.length()-1));
		f(100);
	}
	
	static boolean isPrime(int n){
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	static void f(int n){
		int k=2;
		while(k<=n){
			if(k==n){
				System.out.print(k);
				break;
			}else if(n%k==0){
				System.out.println(k);
				n/=k;
				
			}else{
				k++;
			}
			
		}
	}
}
