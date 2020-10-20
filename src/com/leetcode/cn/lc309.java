package com.leetcode.cn;

class lc309 {
    public int maxProfit(int[] prices) {
        boolean isStart=true;
        int len=prices.length,count=0;
        int[] res=new int[len];
        for(int i=1;i<len;i++){
            if(prices[i]>prices[i-1]){
            	if(count==0){
            		isStart=false;
            		res[i]=res[i-1]+prices[i]-prices[i-1];
            	}
            	if(count==1){
            		if(isStart){
            			res[i]=res[i-1]+prices[i]-prices[i-1];
            			count=0;
            			isStart=false;
            		}else {
            			res[i]=Math.max(res[i-2],res[i-3]+prices[i]-prices[i-1]);
                        count=0;
					}
            		
            	}
                
            }else if(prices[i]<prices[i-1]){
                count++;
                if(count==1){
                    res[i]=res[i-1];
                }
            }
        }
        return res[len-1];
            
    }
    public static void main(String[] args) {
		int[] prices={2,1,2,0,1};
		int res=new lc309().maxProfit(prices);
		System.out.println(res);
	}
}