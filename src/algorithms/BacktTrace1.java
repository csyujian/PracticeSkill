package com.leetcode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BacktTrace1 {
	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;

		List<List<Integer>> res = new ArrayList<>(factorial(len));
		if (len == 0) {
			return res;
		}

		// ʹ�ù�ϣ����һ�������Ƿ�ʹ�ù�
		Set<Integer> used = new HashSet<>(len);
		Deque<Integer> path = new ArrayDeque<>(len);

		dfs(nums, len, 0, path, used, res);
		return res;
	}

	private int factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	private void dfs(int[] nums, int len, int depth,
			Deque<Integer> path, Set<Integer> used,
			List<List<Integer>> res) {
		if (depth == len) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!used.contains(i)) {
				used.add(i);
				path.addLast(nums[i]);

				dfs(nums, len, depth + 1, path, used, res);

				path.removeLast();
				used.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums={1,2,3};
		new BacktTrace1().permute(nums);
	}
}




