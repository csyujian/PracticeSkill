    package com.leetcode.cn;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.Stack;

    /**
     * @author yvzhu
     * @version 1.0
     * @date 2020/10/15 19:52
     */
    public class lc778 {
        int N;

        public int swimInWater(int[][] grid) {
            N = grid.length;
    //        visited = new boolean[N][N];
            int left = 0,right = 2500;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(possible(mid,grid)){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            return left;
        }
        public boolean possible(int T, int[][] grid) {
            int N = grid.length;
            Set<Integer> seen = new HashSet();
            seen.add(0);
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};

            Stack<Integer> stack = new Stack();
            stack.add(0);

            while (!stack.empty()) {
                int k = stack.pop();
                int r = k / N, c = k % N;
                if (r == N-1 && c == N-1) return true;

                for (int i = 0; i < 4; ++i) {
                    int cr = r + dr[i], cc = c + dc[i];
                    int ck = cr * N + cc;
                    if (0 <= cr && cr < N && 0 <= cc && cc < N
                            && !seen.contains(ck) && grid[cr][cc] <= T) {
                        stack.add(ck);
                        seen.add(ck);
                    }
                }
            }

            return false;
        }

        public static void main(String[] args) {
            int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
            int[][] grid1 = {

                    {26,99,80,1,89,86,54,90,47,87},
                    {9,59,61,49,14,55,77,3,83,79},
                    {42,22,15,5,95,38,74,12,92,71},
                    {8,40,64,62,24,85,30,6,96,52},
                    {10,70,57,19,44,27,98,16,25,65},
                    {13,0,76,32,29,45,28,69,53,41},
                    {18,8,21,67,46,36,56,50,51,72},
                    {39,78,48,63,68,91,34,4,11,31},
                    {97,23,60,17,66,37,43,33,84,35},
                    {75,88,82,20,7,73,2,94,93,81}};
            int res = new lc778().swimInWater(grid1);
            System.out.println(res);
        }
    }