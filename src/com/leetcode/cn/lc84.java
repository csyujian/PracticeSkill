package com.leetcode.cn;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/28 13:54
 */
public class lc84 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // �ȷ����ڱ�����ѭ����Ͳ������ǿ��ж�
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
         int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {1, 1};
        lc84 solution = new lc84();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}