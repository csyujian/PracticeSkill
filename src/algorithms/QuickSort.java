package algorithms;

public class QuickSort {
    public void sort(int[] nums,int left,int right){


        if(left<right){
            int label = nums[left];
            int i = left,j = right;
            while(i<j){
                while(i < j && nums[right] >= label){
                    j--;
                }
                if(i < j){
                    nums[i++] = nums[j];
                }

                while(i < j && nums[left] < label){
                    i++;
                }
                if(i < j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = label;
            sort(nums,left,i-1);
            sort(nums,i+1,right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,0,9,1,3,4,2,6};
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
        new QuickSort().sort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
