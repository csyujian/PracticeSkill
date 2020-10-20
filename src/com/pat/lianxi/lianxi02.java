package com.pat.lianxi;
/*
 * ��Ŀ���ж�101-200֮���ж��ٸ����������������������
 * ����������ж������ķ�������һ�����ֱ�ȥ��2��sqrt(�����)��
 * ����ܱ������� ���������������������֮��������
 */
public class lianxi02 {
	int outputAllPrimes(int start,int end){
		int count=0;
		while(start<=end){
			if(isPrime(start)){
				System.out.println(start++);
				count++;
			}
			start++;
		}
		return count;
	}
	boolean isPrime(int n){
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new lianxi02().outputAllPrimes(100, 200));
	}
	
}
