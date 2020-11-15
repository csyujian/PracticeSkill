package algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,5,6,7,8};
//        for(int i = 0;i <= 3;i++){
//            binarySearch(nums,i);
//        }
//        int res = reverse(nums,0);
//        System.out.println(res);
//        for(int i = 0;i <= 8;i++){
//            int res = upperBound(nums,0,nums.length - 1,i);
//            System.out.println(i + " " +res);
//        }
        int res = upperBound(nums,0,nums.length - 1,10);
        System.out.println(10 + " " +res);
    }
    public static void binarySearch(int[] nums,int val){
        int left = 0,right = nums.length - 1;
        while ( left  < right){
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] > val){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        int res = nums[right] > val ? right : left;
        System.out.println();
        System.out.println(val + " " + res);
    }
    static int reverse(int[] nums,int i){
        int val = nums[i];
        int res = 0;
        int left = i + 1;
        int right = nums.length - 1;
        boolean flag = false;
        while (left < right){
            if(!flag && nums[right] > val){
                res = nums[right];
                nums[right] = val;
                flag = true;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left;
            --right;
        }
//        System.out.println(res);
        return res;
    }
    //在递增数列中寻找大于等于的值
    static int upperBound(int[] nums,int left,int right,int val){
        while (left < right){
           int mid = left + (right - left) / 2;
           if(nums[mid] < val){
               left = mid + 1;
           }else{
               right = mid;
           }
        }
        //如果没找到,说明区间内没有比@val 大的值,所以返回right+1;
        return nums[left] < val ? right + 1 : left;
    }
}
