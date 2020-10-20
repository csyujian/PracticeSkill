package interview;

class iw0107 {
    static void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            int a=matrix.length-1;
            for(int j=i;j<a-i;j++){
                int b=matrix[j][a-i];
                int c=matrix[i][j];
                matrix[j][a-i]=c;
                c=b;
                
                b=matrix[a-i][a-j];
                matrix[a-i][a-j]=c;
                c=b;
                
                b=matrix[a-j][i];
                matrix[a-j][i]=c;
                c=b;
                
                matrix[i][j]=c;
            }
        }
    }
    public static void main(String[] args) {
		int[][] a={
		            {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
    	rotate(a);
        for (int[] ints : a) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
	}
    
}