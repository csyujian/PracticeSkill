package com.leetcode;
import java.util.ArrayList;
import java.util.List;

public class BacktTrace {
	 public List<List<Integer>> permute(int[] nums) {
	        // ����������
	        int len = nums.length;
	        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
	        List<List<Integer>> res = new ArrayList<>();

	        if (len == 0) {
	            return res;
	        }

	        boolean[] used = new boolean[len];
	        List<Integer> path = new ArrayList<>();

	        dfs(nums, len, 0, path, used, res);
	        return res;
	    }

	    private void dfs(int[] nums, int len, int depth,
	                     List<Integer> path, boolean[] used,
	                     List<List<Integer>> res) {
	        if (depth == len) {
	            // 3�����ÿ�������Ϊÿһ�㴫�������� path ���������½���
	            res.add(path);
	            return;
	        }

	        for (int i = 0; i < len; i++) {
	            if (!used[i]) {
	                // 1��ÿһ�γ��Զ������µı�����ʾ��ǰ��"״̬"
	                List<Integer> newPath = new ArrayList<>(path);
	                newPath.add(nums[i]);

	                boolean[] newUsed = new boolean[len];
	                System.arraycopy(used, 0, newUsed, 0, len);
	                newUsed[i] = true;

	                dfs(nums, len, depth + 1, newPath, newUsed, res);
	                // 2���������
	            }
	        }
	    }
	    public static void main(String[] args) {
	    	int[] nums={1,2,3};
			new BacktTrace().permute(nums);
		}
}




