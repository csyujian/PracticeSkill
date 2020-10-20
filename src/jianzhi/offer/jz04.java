package jianzhi.offer;

public class jz04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0){
            return false;
        }
        int n=matrix[0].length;
        if(m==0){
            return false;
        }
        return findNumber(matrix,target,0,0,m-1,n-1);
    }
    boolean findNumber(int[][] matrix,int target,int l1,int l2,int r1,int r2){
        if(l1>r1||l2>r2)
            return false;
        int mid1=(l1+r1)/2;
        int mid2=(l2+r2)/2;
        if(matrix[mid1][mid2]==target){
            return true;
        }else if(matrix[mid1][mid2]>target){
            if(l1==r1){
                return findNumber(matrix, target, l1, l2, r1, mid2-1);
            }else if(l2==r2){
                return findNumber(matrix, target, l1, l2, mid1-1, r2);
            }
            return findNumber(matrix,target,l1,l2,mid1-1,mid2-1)||findNumber(matrix, target, l1, mid2, mid1-1, mid2)||findNumber(matrix, target, mid1, l2, mid1, mid2-1)||findNumber(matrix, target, l1, mid2+1, mid1-1, r2)||findNumber(matrix, target, mid1+1, l2, mid1+1, r2);
        }else{
            if(l1==r1){
                return findNumber(matrix, target, l1, mid2+1, r1, r2);
            }else if(l2==r2){
                return findNumber(matrix, target, mid1+1, l2, r1, r2);
            }
            return findNumber(matrix,target,mid1+1,mid2+1,r1,r2)||findNumber(matrix,target,l1,mid2+1,mid1,r2)||findNumber(matrix,target,mid1+1,l2,r1,mid2);
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int[][] matrix1={{1,3}};
        int[][] matrix3={
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
        boolean res= new jz04().findNumberIn2DArray(matrix3, 5);
        System.out.println(res);

    }
}