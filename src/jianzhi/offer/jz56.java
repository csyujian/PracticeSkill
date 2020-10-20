package jianzhi.offer;

public class jz56 {
	public int[] getSlidingMax(int[] nums,int k){
		int len=nums.length;
		int[] res=new int[len-k+1];
		int slow=0,fast=0,cnt=0;
		for(;fast<len;fast++){
			if(fast<k-1){
				if(fast>0&&nums[fast]>=nums[slow]){
					slow=fast;
				}
			}else{
				if(nums[slow]>nums[fast]){
					res[cnt++]=nums[slow];
					slow=slow==fast-k+1?slow+1:slow;
					int temp=slow;
					for(int j=slow+1;j<=fast;j++){
						if(nums[j]>nums[temp]){
							temp=j;
						}
					}
					slow=temp;
				}else{
					res[cnt++]=nums[fast];
					slow=fast;
				}
				
				
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums={-95,92,-85,59,-59,-14,88,-39,2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39,90,-9,-72,-88,-72,93,38,14,-83,-2,21,4,-75,-65,3,63,100,59,-48,43,35,-49,48,-36,-64,-13,-7,-29,87,34,56,-39,-5,-27,-28,10,-57,100,-43,-98,19,-59,78,-28,-91,67,41,-64,76,5,-58,-89,83,26,-7,-82,-32,-76,86,52,-6,84,20,51,-86,26,46,35,-23,30,-51,54,19,30,27,80,45,22};
		int[] nums1={1,-1,3,4};
		int[] res=new jz56().getSlidingMax(nums1 ,1);
		for(int r:res){
			System.out.println(r);
		}
	}
}
