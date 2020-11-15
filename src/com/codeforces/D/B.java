package com.codeforces.D;

import java.util.*;

public class B {
    public static void main(String[] args) {
        B b = new B();
        b.solve();
    }
    Scanner in = new Scanner(System.in);
    private void solve() {
        int t = in.nextInt();
        while (t-- >0){
            int n = in.nextInt();
            int[] nums = new int[n];
            boolean res;
            for(int i = 0;i < n;i++){
                nums[i] = in.nextInt();
            }
            res = helper(nums);
            System.out.println(res ? "YES" : "NO");
        }
    }

    private boolean helper(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
