package com.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author  yvzhu
 * @version 1.0
 */
public class Lc04 {

    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<Integer>();
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                temp.add(nums1[i++]);
            }else{
                temp.add(nums2[j++]);
            }
        }
        while(i<m){
            temp.add(nums1[i++]);
        }
        while(j<n){
            temp.add(nums2[j++]);
        }
        double res=0.0;
        if(temp.size()%2==0){
            res=(temp.get(temp.size()/2)+temp.get(temp.size()/2-1))/2.0;
        }else{
            res=temp.get(temp.size()/2);
        }
        return res;
    }
    public static void main(String[] args) {
    	int[] nums1={2,3};
    	int[] nums2 ={1,4};
		new Lc04().findMedianSortedArrays(nums1, nums2);
	}
}
