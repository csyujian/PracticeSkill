package jianzhi.offer;

import javax.swing.plaf.IconUIResource;
import java.util.PriorityQueue;
/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/13 10:37
 */
public class jz51 {

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return 0;
        }
        int[] copy = new int[len];
        for(int i = 0;i < len;i++){
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy,0,len - 1,temp);
    }

    private int reversePairs(int[] copy, int left, int right, int[] temp) {
        if(left == right){
            return 0;
        }

        int mid = left + (right - left) / 2;

        int leftPairs = reversePairs(copy,left,mid,temp);
        int rightPairs = reversePairs(copy,mid+1,right,temp);
        if(copy[mid] <= copy[mid+1]){
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(copy,left,mid,right,temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] copy, int left, int mid, int right, int[] temp) {
        for(int i = left;i <= right;i++){
            temp[i] = copy[i];
        }
        int count = 0;
        int i = left,j = mid + 1;
        for(int k = left ;k <= right;k++){
            if(i == mid + 1){
                copy[k] = temp[j];
                j++;
            }else if(j == right + 1){
                copy[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                copy[k] = temp[i];
                i++;
            }else{
                copy[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        int res = new jz51().reversePairs(nums);
        System.out.println(res);
    }
}