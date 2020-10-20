package jianzhi.offer;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/12 16:25
 */
public class jz29 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int m = matrix.length,n = matrix[0].length;
        int[] res = new int[m*n];
        int top = 0,down = m - 1;
        int left = 0,right = n - 1;
        int index = 0;

            while (index < m * n) {
                for (int i = left; i <= right; i++) {
                    res[index++] = matrix[top][i];
                }
                top++;
                for (int i = top; i <= down; i++) {
                    res[index++] = matrix[i][right];
                }
                right--;
                for (int i = right; i >= left; i--) {
                    res[index++] = matrix[down][i];
                }
                down--;
                for (int i = down; i >= top; i--) {
                    res[index++] = matrix[i][left];
                }
                left++;
            }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int[] res = new jz29().spiralOrder(matrix);
        for(int i : res){
            System.out.println(i);
        }
        StringBuilder sb = new StringBuilder();
        
    }
}