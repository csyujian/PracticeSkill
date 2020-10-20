package other;

import java.util.*;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/3 13:26
 */
public class tc4 {
    public int valley(int[] nums) {
        // write your code here
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 1;i < len;i++){
            if(nums[i] > nums[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = len - 1;i > 0;i--) {
            if (nums[i - 1] > nums[i]) {
                right[i - 1] = right[i] + 1;
            }
        }
        int res = 0;
        for(int i = 0;i < len;i++){
            for(int j = i + 1; j < len;j++){
                if(nums[i] == nums[j] && (j - i + 1) % 2 == 0){
                    int needLen = (j - i - 1) / 2;
                    if(right[i] >= needLen && left[j] >= needLen){
                        res = Math.max(res,j - i + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,2,3,4,5};
        int res =new tc4().valley(nums);
        System.out.println(res);
    }
}