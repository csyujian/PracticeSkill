package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AC{
	class Trie{
		int[] sons;
		int fail;
		List<Integer> exists;
		public Trie() {
			sons=new int[26];
			fail=0;
			exists=new ArrayList<>();
		}
	}
	Trie[] tries;
	int cnt;
	public AC() {
		tries = new Trie[50010];
		for(int i=0;i<50010;i++){
			tries[i]=new Trie();
		}
		cnt=0;
	}
	int insert(char[] c){
		int len=c.length,ch=0,now=0;
		for(int i=0;i<len;i++){
			ch=c[i]-'a';
			if(tries[now].sons[ch]==0){
				tries[now].sons[ch]=++cnt;
			}
			now=tries[now].sons[ch];
		}
		tries[now].exists.add(len);
		return cnt;
	}
	void build_fail(){
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<26;i++){
			if(tries[0].sons[i]!=0){
				queue.offer(tries[0].sons[i]);
			}
		}
		int now=0,y=0,fafail=0;
		while(!queue.isEmpty()){
			now=queue.poll();
			for(int i=0;i<26;i++){
				if(tries[now].sons[i]!=0){
					y=tries[now].sons[i];
					fafail=tries[now].fail;
					while(fafail != 0 && tries[fafail].sons[i] == 0){
						fafail=tries[fafail].fail;
					}
					//fafail为0是，代表无最长后缀，则指向root
					//tries[fafail].son[i]不为0，则有可以指向的结点
					//但是最终fafail都是结点
					tries[y].fail=tries[fafail].sons[i];
					if(tries[tries[y].fail].exists.size()>0){
						int exlen=tries[tries[y].fail].exists.size();
						for(int j=0;j<exlen;j++){
							tries[y].exists.add(tries[tries[y].fail].exists.get(j));
						}
					}
					queue.offer(tries[now].sons[i]);
				}

			}
		}
	}
	void query(char[] t){
		int len=t.length,now=0,ch=0;
		for(int i=0;i<len;i++){
			ch=t[i]-'a';
			//找到匹配t[i]的结点
			while(tries[now].sons[ch]==0 && tries[now].fail!=0){
				now=tries[now].fail;
			}
			//tries[now].sons[ch]!=0
			if(tries[now].sons[ch]!=0){
				now=tries[now].sons[ch];
			}
			//tries[now].fail!=0。结点无匹配
			else{
				continue;
			}
			for(int j=0;j<tries[now].exists.size();j++){
				
				for(int k=0;k<=i;k++){
					if(k<i+1-tries[now].exists.get(j)){
						System.out.print(" ");
					}else{
						System.out.print(t[k]);
					}
					
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		AC ac=new AC();
		String[] patternStrings = {"he","e","hers","his","she"};
		for(int i=0;i<patternStrings.length;i++){
			ac.insert(patternStrings[i].toCharArray());
		}
		ac.build_fail();
		String tString = "ahishers";
		System.out.println(tString);
		ac.query(tString.toCharArray());
	}
}